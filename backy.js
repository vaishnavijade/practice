// Import necessary libraries
const express = require('express');
const mongoose = require('mongoose');

const app = express();
const PORT = 5000;console.log('MongoDB connected successfully');
//console.error('Database connection error:', err.message);
console.error(err.stack);
console.error(err);

// Middleware to parse JSON requests
app.use(express.json());

// MongoDB connection setup
async function connectDB() {
    try {
        await mongoose.connect('mongodb://localhost:27017/utilDB', {
            // useNewUrlParser: true,
            // useUnifiedTopology: true,
        });
        console.log('MongoDB connected successfully');
    } catch (err) {
        console.error('Database connection error:', err.message);
        process.exit(1);
    }
}
connectDB();

// Invoice Schema and Model
const itemSchema = new mongoose.Schema({
  utilitytype: { type: String, required: true },
  billamount: { type: Number, required: true },
  date: { type: Date, required: true },
});



// Pre-save hook for validation
/*invoiceSchema.pre('save', function(next) {
    this.items.forEach(item => {
        if (item.quantity <= 0 || item.price <= 0) {
            return next(new Error('Item quantity and price must be greater than zero.'));
        }
    });
    next();
});*/

const Invoice = mongoose.model('Invoice', itemSchema);

// Routes

// Get all invoices
app.get('/utilities', async (req, res) => {
    try {
        const invoices = await Invoice.find();
        res.status(200).json({ utilities });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Create a new invoice
app.post('/utility', async (req, res) => {
    try {
        const { customerName, billingAddress, items } = req.body;

        // Calculate items' amounts and total amount
        const calculatedItems = items.map(item => ({
            ...item,
            amount: item.quantity * item.price,
        }));
        const totalAmount = calculatedItems.reduce((sum, item) => sum + item.amount, 0);

        // Determine next invoice number
        const lastInvoice = await Invoice.findOne().sort({ invoiceNumber: -1 });
        const invoiceNumber = lastInvoice ? lastInvoice.invoiceNumber + 1 : 1;

        const invoice = new Invoice({
            invoiceNumber,
            customerName,
            billingAddress,
            items: calculatedItems,
            totalAmount,
        });

        const savedInvoice = await invoice.save();
        res.status(201).json({ success: true, data: savedInvoice, message: 'Invoice created' });
    } catch (err) {
        res.status(500).json({ success: false, message: err.message });
    }
});

// Get an invoice by ID
/*app.get('/utility/:id', async (req, res) => {
    try {
        const invoice = await Invoice.findOne({ invoiceNumber: parseInt(req.params.id) });
        if (!invoice) {
            return res.status(404).json({ message: 'Utility is not found' });
        }
        res.status(200).json({ success: true, data: invoice });
    } catch (err) {
        res.status(500).json({ success: false, message: err.message });
    }
});*/

// GET an invoice by ID
app.get('/utility/:id', async (req, res) => {
  try {
      const id = req.params.id;

      // Retrieve the invoice by ID
      const invoice = await Invoice.findById(id);

      if (!invoice) {
          return res.status(404).json({ error: 'Utility is not found' });
      }

      res.status(200).json(invoice);
  } catch (err) {
      res.status(500).json({ error: err.message });
  }
});


// Update an invoice
app.put('/api/invoices/:id', async (req, res) => {
    try {
        const { customerName, billingAddress, items } = req.body;

        // Recalculate totals
        const calculatedItems = items.map(item => ({
            ...item,
            amount: item.quantity * item.price,
        }));
        const totalAmount = calculatedItems.reduce((sum, item) => sum + item.amount, 0);

        const updatedInvoice = await Invoice.findOneAndUpdate(
            { invoiceNumber: parseInt(req.params.id) },
            { customerName, billingAddress, items: calculatedItems, totalAmount },
            { new: true, runValidators: true }
        );

        if (!updatedInvoice) {
            return res.status(404).json({ success: false, message: 'No utility found' });
        }

        res.status(200).json({ success: true, data: updatedInvoice, message: 'Invoice updated' });
    } catch (err) {
        res.status(500).json({ success: false, message: err.message });
    }
});

// Delete an invoice
app.delete('/api/invoices/:id', async (req, res) => {
    try {
        const deletedInvoice = await Invoice.findOneAndDelete({ invoiceNumber: parseInt(req.params.id) });
        if (!deletedInvoice) {
            return res.status(404).json({ success: false, message: 'Invoice not found' });
        }
        res.status(200).json({ success: true, data: deletedInvoice, message: 'Invoice deleted' });
    } catch (err) {
        res.status(500).json({ success: false, message: err.message });
    }
});

// Error handling middleware
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({ error: 'Something went wrong' });
});

// Start server
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
/*const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

// Create an Express app
const app = express();
const PORT = 5000;

// Middleware to parse JSON requests
app.use(bodyParser.json());

// MongoDB Connection
const connectDB = async () => {
  try {
    await mongoose.connect('mongodb://10.10.9.107:27017/invoiceDB', { useNewUrlParser: true, useUnifiedTopology: true });
    console.log('MongoDB connected');
  } catch (error) {
    console.error('MongoDB connection failed', error);
    process.exit(1);
  }
};

// Invoice Schema
const itemSchema = new mongoose.Schema({
  itemName: { type: String, required: true },
  quantity: { type: Number, required: true, min: 1 },
  price: { type: Number, required: true, min: 0 },
  amount: { type: Number, required: true }
});

const invoiceSchema = new mongoose.Schema({
  invoiceNumber: { type: Number, unique: true, required: true },
  customerName: { type: String, required: true },
  billingAddress: { type: String, required: true },
  date: { type: Date, default: Date.now },
  items: [itemSchema],
  totalAmount: { type: Number, required: true }
});

const Invoice = mongoose.model('Invoice', invoiceSchema);

// Routes

// GET all invoices
app.get('/api/invoices/:id', async (req, res) => {
    try {
      const invoice = await Invoice.findOne({ invoiceNumber: req.params.id });
      if (!invoice) {
        return res.status(404).json({ success: false, message: 'Invoice not found' });
      }
      res.status(200).json({ success: true, data: invoice });
    } catch (err) {
      res.status(500).json({ success: false, message: err.message });
    }
  });
  

// POST create a new invoice
app.put('/api/invoices/:id', async (req, res) => {
    try {
      const { customerName, billingAddress, items } = req.body;
  
      if (!customerName || !billingAddress || !Array.isArray(items) || items.length === 0) {
        return res.status(400).json({ success: false, message: 'Invalid input data' });
      }
  
      const updatedInvoice = await Invoice.findOneAndUpdate(
        { invoiceNumber: req.params.id },
        { customerName, billingAddress, items },
        { new: true }
      );
  
      if (!updatedInvoice) {
        return res.status(404).json({ success: false, message: 'Invoice not found' });
      }
  
      res.status(200).json({ success: true, data: updatedInvoice });
    } catch (err) {
      res.status(500).json({ success: false, message: err.message });
    }
  });
  
  

// GET an invoice by ID
app.get('/api/invoices', async (req, res) => {
    try {
      const invoices = await Invoice.find();
      if (invoices.length === 0) {
        return res.status(404).json({ success: false, message: 'No invoices found' });
      }
      res.status(200).json({ success: true, data: invoices });
    } catch (err) {
      console.error(err); // Log detailed error
      res.status(500).json({ success: false, message: err.message });
    }
  });
  

// PUT update an invoice by ID
app.put('/api/invoices/:id', async (req, res) => {
  try {
    const { customerName, billingAddress, items } = req.body;
    const calculatedItems = items.map(item => ({
      ...item,
      amount: item.quantity * item.price,
    }));
    const totalAmount = calculatedItems.reduce((sum, item) => sum + item.amount, 0);

    const updatedInvoice = await Invoice.findOneAndUpdate(
      { invoiceNumber: req.params.id },
      { customerName, billingAddress, items: calculatedItems, totalAmount },
      { new: true, runValidators: true }
    );

    if (!updatedInvoice) {
      return res.status(404).json({ success: false, message: 'Invoice not found' });
    }

    res.status(200).json({ success: true, data: updatedInvoice, message: 'Invoice updated' });
  } catch (err) {
    res.status(500).json({ success: false, message: err.message });
  }
});
app.post('/api/invoices', async (req, res) => {
    try {
      const { customerName, billingAddress, items } = req.body;
  
      if (!customerName || !billingAddress || !Array.isArray(items) || items.length === 0) {
        return res.status(400).json({ success: false, message: 'Invalid input data' });
      }
  
      const calculatedItems = items.map(item => ({
        ...item,
        amount: item.quantity * item.price,
      }));
      const totalAmount = calculatedItems.reduce((sum, item) => sum + item.amount, 0);
  
      const lastInvoice = await Invoice.findOne().sort({ invoiceNumber: -1 });
      const invoiceNumber = lastInvoice ? lastInvoice.invoiceNumber + 1 : 1;
  
      const invoice = new Invoice({ invoiceNumber, customerName, billingAddress, items: calculatedItems, totalAmount });
      const savedInvoice = await invoice.save();
  
      res.status(201).json({ success: true, data: savedInvoice });
    } catch (err) {
      res.status(500).json({ success: false, message: err.message });
    }
  });
  
  
// DELETE an invoice by ID
app.delete('/api/invoices/:id', async (req, res) => {
    try {
      const deletedInvoice = await Invoice.findOneAndDelete({ invoiceNumber: req.params.id });
      if (!deletedInvoice) {
        return res.status(404).json({ success: false, message: 'Invoice not found' });
      }
      res.status(200).json({ success: true, data: deletedInvoice });
    } catch (err) {
      res.status(500).json({ success: false, message: err.message });
    }
  });
  

// Start the server
connectDB();
app.listen(PORT, () => {
  console.log(Server running at http://localhost:${PORT});
});*/