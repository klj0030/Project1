package edu.auburn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductController {

    public AddProductView view;
    public SQLiteDataAdapter adapter;

    public AddProductController(AddProductView view, SQLiteDataAdapter adapter) {
        this.view = view;
        this.adapter = adapter;

        this.view.btnAdd.addActionListener(new AddButtonListener());
        this.view.btnCancel.addActionListener(new CancelButtonListener());
    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ProductModel product = new ProductModel();

            String id = AddProductController.this.view.txtProductID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "ProductID can not be null!");
                return;
            }

            try {
                product.mProductID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ProductID is invalid!");
                return;
            }

            String name = AddProductController.this.view.txtName.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Product name can not be empty!");
                return;
            }
            product.mName = name;

            String price = AddProductController.this.view.txtPrice.getText();
            try {
                product.mPrice = Double.parseDouble(price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price is invalid!");
                return;
            }

            String quantity = AddProductController.this.view.txtQuantity.getText();
            try {
                product.mQuantity = Double.parseDouble(quantity);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }

            JOptionPane.showMessageDialog(null, "You want to add product: " + product);

            switch (adapter.saveProduct(product)) {

                case SQLiteDataAdapter.PRODUCT_DUPLICATE_ERROR:
                    JOptionPane.showMessageDialog(null, "Product NOT added successfully! " + product);

                default:
                    JOptionPane.showMessageDialog(null, "Product added successfully! " + product);
            }
        }
    }

    class CancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JOptionPane.showMessageDialog(null, "You Clicked the Cancel Button!");
        }
    }
}