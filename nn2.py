import numpy as np
import random

# Character-Level Language Model (Inspired by Karpathy's "Make More")
class CharLevelNN:
    def __init__(self, vocab_size, hidden_size):
        self.vocab_size = vocab_size
        self.hidden_size = hidden_size
        
        # Initialize weights
        self.Wxh = np.random.randn(hidden_size, vocab_size) * 0.01
        self.Whh = np.random.randn(hidden_size, hidden_size) * 0.01
        self.Why = np.random.randn(vocab_size, hidden_size) * 0.01
        
        self.bh = np.zeros((hidden_size, 1))
        self.by = np.zeros((vocab_size, 1))
    
    def forward(self, inputs, hprev):
        """Forward pass through the RNN"""
        xs, hs, ys, ps = {}, {}, {}, {}
        hs[-1] = np.copy(hprev)
        
        for t in range(len(inputs)):
            xs[t] = np.zeros((self.vocab_size, 1))  # One-hot encoding
            xs[t][inputs[t]] = 1
            hs[t] = np.tanh(np.dot(self.Wxh, xs[t]) + np.dot(self.Whh, hs[t-1]) + self.bh)
            ys[t] = np.dot(self.Why, hs[t]) + self.by
            ps[t] = np.exp(ys[t]) / np.sum(np.exp(ys[t]))  # Softmax
        
        return xs, hs, ys, ps
    
    def loss_function(self, ps, targets):
        """Compute cross-entropy loss"""
        loss = 0
        for t in range(len(targets)):
            loss += -np.log(ps[t][targets[t], 0])
        return loss
    
    def train(self, inputs, targets, hprev, learning_rate=0.1):
        """Train using backpropagation through time (BPTT)"""
        xs, hs, ys, ps = self.forward(inputs, hprev)
        
        # Initialize gradients
        dWxh, dWhh, dWhy = np.zeros_like(self.Wxh), np.zeros_like(self.Whh), np.zeros_like(self.Why)
        dbh, dby = np.zeros_like(self.bh), np.zeros_like(self.by)
        dhnext = np.zeros_like(hs[0])
        
        # Backpropagation
        for t in reversed(range(len(inputs))):
            dy = np.copy(ps[t])
            dy[targets[t]] -= 1  # Softmax gradient
            dWhy += np.dot(dy, hs[t].T)
            dby += dy
            dh = np.dot(self.Why.T, dy) + dhnext
            dhraw = (1 - hs[t] ** 2) * dh  # tanh gradient
            dbh += dhraw
            dWxh += np.dot(dhraw, xs[t].T)
            dWhh += np.dot(dhraw, hs[t-1].T)
            dhnext = np.dot(self.Whh.T, dhraw)
        
        # Gradient clipping
        for dparam in [dWxh, dWhh, dWhy, dbh, dby]:
            np.clip(dparam, -5, 5, out=dparam)
        
        # Update weights
        self.Wxh -= learning_rate * dWxh
        self.Whh -= learning_rate * dWhh
        self.Why -= learning_rate * dWhy
        self.bh -= learning_rate * dbh
        self.by -= learning_rate * dby
        
        return self.loss_function(ps, targets), hs[len(inputs)-1]

# Example usage
vocab_size = 27  # Assume 26 letters + space
hidden_size = 100
model = CharLevelNN(vocab_size, hidden_size)

# Example input (random character sequence)
inputs = [random.randint(0, vocab_size - 1) for _ in range(10)]
targets = [random.randint(0, vocab_size - 1) for _ in range(10)]
hprev = np.zeros((hidden_size, 1))

# Train the model
loss, hprev = model.train(inputs, targets, hprev, learning_rate=0.1)
print("Loss after training step:", loss)
