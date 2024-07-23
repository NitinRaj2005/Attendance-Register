import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Attendance_Register{

    
    private static int currentRow = 1;  // Start from row 1

    public static void main(String[] args) {
        
        Frame frame = new Frame("AWT Table Example");

       
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(100, 3));

        
        Component[][] components = new Component[100][3];
        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 0) {
                    if (col == 0) {
                        components[row][col] = new Label("Roll No.");
                    } else if (col == 1) {
                        Button presentButton = new Button("Present");
                        presentButton.setBackground(Color.GREEN);
                        components[row][col] = presentButton;
                    } else if (col == 2) {
                        Button absentButton = new Button("Absent");
                        absentButton.setBackground(Color.RED);
                        components[row][col] = absentButton;
                    }
                } else {
                    if (col == 0) {
                        components[row][col] = new Label(String.valueOf(row));  // Print only row number
                    } else {
                        components[row][col] = new TextField("Cell " + (row + 1) + "," + (col + 1));
                    }
                }
                panel.add(components[row][col]);
            }
        }

       
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(panel);

     
        frame.add(scrollPane);

       
        ((Button) components[0][1]).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentRow < 100) {  // Ensure we don't go out of bounds
                    ((TextField) components[currentRow][1]).setText("Present");
                    ((TextField) components[currentRow][1]).setBackground(Color.GREEN);
                    currentRow++;
                } else {
                    System.out.println("All rows in column 1 are already set.");
                }
                System.out.println("Present button clicked");
            }
        });

        ((Button) components[0][2]).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentRow < 100) {  // Ensure we don't go out of bounds
                    ((TextField) components[currentRow][2]).setText("Absent");
                    ((TextField) components[currentRow][2]).setBackground(Color.RED);
                    currentRow++;
                } else {
                    System.out.println("All rows in column 2 are already set.");
                }
                System.out.println("Absent button clicked");
            }
        });

       
        frame.setSize(1000, 800);
        frame.setVisible(true);


        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
