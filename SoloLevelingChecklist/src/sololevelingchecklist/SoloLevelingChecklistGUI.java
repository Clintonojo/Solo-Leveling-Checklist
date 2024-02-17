/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sololevelingchecklist;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SoloLevelingChecklistGUI extends javax.swing.JFrame {
    private static JTextField nameText;
    private static JTextField classText;
    private static JLabel nameLabel;
    private static JLabel classLabel;
    private static JLabel expLabel;
    private static JLabel rankLabel; // New label for player rank
    private static int exp;
    private static ArrayList<String> playerInfoList = new ArrayList<>();

    public SoloLevelingChecklistGUI() {
        initComponents();
    }

    private void initComponents() {
         


        JPanel panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);

        nameLabel = new JLabel("Player Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        classLabel = new JLabel("Player Class:");
        classLabel.setBounds(10, 50, 80, 25);
        panel.add(classLabel);

        classText = new JTextField(20);
        classText.setBounds(100, 50, 165, 25);
        panel.add(classText);

        JButton startButton = new JButton("Start");
        startButton.setBounds(10, 80, 80, 25);
        panel.add(startButton);

        expLabel = new JLabel();
        expLabel.setBounds(10, 110, 300, 25);
        panel.add(expLabel);

        rankLabel = new JLabel(); // Initialize rank label
        rankLabel.setBounds(10, 130, 300, 25);
        panel.add(rankLabel);

        JButton completeTaskButton = new JButton("Complete Task");
        completeTaskButton.setBounds(100, 80, 120, 25);
        panel.add(completeTaskButton);

        JButton viewAllInfoButton = new JButton("View All Player Info");
        viewAllInfoButton.setBounds(230, 80, 160, 25);
        panel.add(viewAllInfoButton);

        JLabel searchLabel = new JLabel("Search by Name:");
        searchLabel.setBounds(10, 160, 120, 25);
        panel.add(searchLabel);

        JTextField searchTextField = new JTextField();
        searchTextField.setBounds(130, 160, 150, 25);
        panel.add(searchTextField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(290, 160, 90, 25);
        panel.add(searchButton);

        completeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                completeTask();
            }
        });

      
   startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerNameInput = nameText.getText();
                String playerClassInput = classText.getText();
                if (!playerNameInput.isEmpty() && !playerClassInput.isEmpty()) {
                    String playerName = playerNameInput;
                    String playerClass = playerClassInput;
                    exp = 0; // Reset EXP when starting
                    updateExpArea("", 0); // Update GUI with initial player info
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both player name and class.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        
});


        viewAllInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPlayerInfo();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = searchTextField.getText();
                if (!searchName.isEmpty()) {
                    searchPlayer(searchName);
                }
            }
        });

        setSize(400, 300);
    }

private static void completeTask() {
    String taskName = JOptionPane.showInputDialog(null, "Enter task name:");
    if (taskName != null && !taskName.isEmpty()) {
        String taskDescription = JOptionPane.showInputDialog(null, "Enter task description:");
        if (taskDescription != null && !taskDescription.isEmpty()) {
            String input = JOptionPane.showInputDialog(null, "Enter EXP earned for completing task:");
            if (input != null && !input.isEmpty()) {
                int expEarned = Integer.parseInt(input);
                exp += expEarned;
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' completed! You earned " + expEarned + " EXP.");
                updateExpArea(taskName + " - " + taskDescription, expEarned);
            }
        }
    }
}


    private static void updateExpArea(String taskName, int expEarned) {
        String playerName = nameText.getText();
        String playerClass = classText.getText();
        String playerInfo = "Player Name: " + playerName + " | Player Class: " + playerClass + " | EXP: " + exp +
                "\nLast Task: '" + taskName + "' | EXP Earned: " + expEarned;
        expLabel.setText(playerInfo);
        playerInfoList.add(playerInfo);
        String playerRank = calculatePlayerRank(exp);
        rankLabel.setText("Player Rank: " + playerRank);
    }

    private static String calculatePlayerRank(int exp) {
        // Implement your logic to calculate player rank based on EXP
        // Example logic:
        if (exp >= 50000000) {
            return "God";
        } else if (exp >= 45000000) {
            return "SSS";
        } else if (exp >= 35000000) {
            return "SS";
        } else if (exp >= 30000000) {
            return "S";
        } else if (exp >= 25000000) {
            return "A+";
        } else if (exp >= 20000000) {
            return "A";
        } else if (exp >= 15000000) {
            return "B+";
        } else if (exp >= 10000000) {
            return "B";
        } else if (exp >= 5000000) {
            return "C";
        } else if (exp >= 2500000) {
            return "D";
        } else if (exp >= 1000000) {
            return "E";
        } else {
            return "Non-Awakened";
        }
    }

    private static void showPlayerInfo() {
        StringBuilder playerInfo = new StringBuilder("All Player Information:\n");
        for (String info : playerInfoList) {
            playerInfo.append(info).append("\n");
        }
        JOptionPane.showMessageDialog(null, playerInfo.toString(), "Player Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void searchPlayer(String searchName) {
        StringBuilder searchResult = new StringBuilder("Search Results for '" + searchName + "':\n");
        boolean found = false;
        for (String info : playerInfoList) {
            if (info.contains(searchName)) {
                searchResult.append(info).append("\n");
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, searchResult.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No results found for '" + searchName + "'.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SoloLevelingChecklistGUI().setVisible(true);
            }
        });
    }
}



  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField nameText;
    // End of variables declaration//GEN-END:variables

