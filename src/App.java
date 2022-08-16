import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Color;


import java.awt.GridLayout;



public class App extends JFrame implements ListSelectionListener , ActionListener {

    double value1 = 0;
    double value2 = 0;
    Double result = 0.0;
    double toBeCalculated = 0.0;
    
    String operator = "";


    public static final String[][] buttons_text = {
                {"CE", "C", "<", "/"},
                {"7", "8", "9", "+"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "*"},
                { "+/-", "0" , "." , "="}
    };


    public static final Font btn_font = new Font(Font.SANS_SERIF, Font.BOLD, 24);
    public static final Font panel_font = new Font(Font.SANS_SERIF, Font.BOLD, 13);

            JTextField textField = new JTextField(13);
            JTextField operationField = new JTextField(13);

    public App(){
        super("Calculator");
        
        


            textField.setFont(btn_font.deriveFont(Font.PLAIN));
            textField.setText("0");

            operationField.setFont(btn_font.deriveFont(Font.PLAIN));
            // operationField.setBackground(Color.RED);
            operationField.setForeground(Color.GREEN);
            operationField.setBorder(javax.swing.BorderFactory.createEmptyBorder());




        JPanel btnPanel = new JPanel(new GridLayout(5, 4));
  
        
            for (int i = 0; i < buttons_text.length; i++) {
                for (int j = 0; j < buttons_text[i].length; j++) {
                    JButton btn = new JButton(buttons_text[i][j]);
                    btn.setFont(btn_font);
                    btn.setBackground(Color.WHITE);
                    btnPanel.add(btn);
                    btn.addActionListener(this);;
                }
            }

        JPanel mainPanel = new JPanel();
        mainPanel.add(textField, BorderLayout.PAGE_START);
        mainPanel.add(operationField, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.CENTER);

        JFrame frame = new JFrame("Calc");
        frame.setBounds(10, 12, 300, 350);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void showInLabel(){

       operationField.setText(operationField.getText() + "" + operator);

    }

    public static void main(String[] args) throws Exception {
            new App().setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        switch (action) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".":
            String value = textField.getText();

                    if (value.equals("0")) {
                        textField.setText(action);
                        operationField.setText(action);
                    }
                    else{
                        if  (value.contains(".") && action.equals(".")){
                            //do nothing 
                        }
                        else{
                            textField.setText(value + action);
                        }
                    }
                    break;

            case "+", "-", "*", "/":

                    operator = action;
                    value1 = Double.parseDouble(textField.getText());
                    textField.setText("0");
                    showInLabel();
                    break;

            case "CE" :

                    textField.setText("0");
                    System.out.println("the text is set to default value");
                    break;

            case "<" :
                    
                    String text1 = textField.getText();


                        if(text1.length() > 1){

                            text1 = text1.substring(0, text1.length()-1);
                        }
                        else{
                            text1 = "0";
                        }

                    textField.setText(text1);
                    System.out.println("removed the las entered value");
                    break;
            
            case "C" :

                    value1 = 0;
                    operator = "";
                    textField.setText("0");
                    System.out.println("the text is set to default value ");
                    break;

            case "+/-" :
                        
                   double signe = Double.parseDouble(String.valueOf(textField.getText()));
                   signe = signe * (-1);
                   textField.setText(String.valueOf(signe));
                   operationField.setText(String.valueOf(signe));
                        
                    
            case "=" : 
                    
                    value2 = Double.parseDouble(textField.getText());
                    operationField.setText(operationField.getText() + value2);



                    switch(operator) {

                        case "+" :
                            result = value1 + value2;
                            break;

                        case "-" :
                            result = value1 - value2;
                            break;
                   
                 
                        case "*" :
                            result = value1 * value2;
                            break;
                    
                    
                        case "/" :
                            result = value1 / value2;
                            break;

                    default : return;
                   
                    }

                    textField.setText(result.toString());

            default:

            break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
