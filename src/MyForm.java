import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MyForm {
    private JPanel mainPanel;
    private JTextArea firstNameTextArea;
    private JTextArea lastNameTextArea;
    private JTextArea patronymicTextArea;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel patronymicLabel;
    private JButton colExpButton;
    private JButton clearButton;
    private JTextArea fullNameTextArea;
    private JLabel fullNameTextLabel;

    public MyForm() {
        colExpButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (colExpButton.getText().equals("Collapse")) {
                    if (firstNameTextArea.getText().length() != 0
                            && lastNameTextArea.getText().length() != 0) {
                        colExpButton.setText("Expand");
                        fullNameTextArea.setText(createFullName());
                        setNamesFieldsVisible(false);
                        setFullNameVisible(true);
                    } else {
                        showErrorMessage();
                    }
                } else {
                    String[] dataFromArea = fullNameTextArea.getText().split("\\s+");
                    if (dataFromArea.length < 2) {
                        showErrorMessage();
                    } else {
                        clearTextAreas();
                        firstNameTextArea.setText(dataFromArea[0]);
                        lastNameTextArea.setText(dataFromArea[1]);
                        if (dataFromArea.length > 2) {
                            patronymicTextArea.setText(dataFromArea[2]);
                        }
                        colExpButton.setText("Collapse");
                        setFullNameVisible(false);
                        setNamesFieldsVisible(true);
                    }
                }
            }
        });
        clearButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextAreas();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void clearTextAreas() {
        firstNameTextArea.setText("");
        lastNameTextArea.setText("");
        patronymicTextArea.setText("");
        fullNameTextArea.setText("");
    }

    private String createFullName() {
        return firstNameTextArea.getText() + " "
                + lastNameTextArea.getText() + " "
                + patronymicTextArea.getText();
    }

    private void setNamesFieldsVisible(boolean arg) {
        firstNameTextArea.setVisible(arg);
        lastNameTextArea.setVisible(arg);
        patronymicTextArea.setVisible(arg);
        firstNameLabel.setVisible(arg);
        lastNameLabel.setVisible(arg);
        patronymicLabel.setVisible(arg);
    }

    private void setFullNameVisible(boolean arg) {
        fullNameTextArea.setVisible(arg);
        fullNameTextLabel.setVisible(arg);
    }

    private void showErrorMessage() {
        JOptionPane.showMessageDialog(mainPanel, "Please, enter a name and last name", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
