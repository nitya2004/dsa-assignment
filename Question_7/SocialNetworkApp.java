package CourseWork.Question_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// User class to represent each node
class User {
  String name;
  ImageIcon image;
  int followers;
  
  // Constructor
  public User(String name, ImageIcon image, int followers) {
    this.name = name;
    this.image = image;  
    this.followers = followers;
  }
}

// Edge class to represent connections between users
class Edgee {
  User user1;

  User user2;
  int weight;  // based on likes, comments, shares
  
  public Edgee(User user1, User user2, int weight) {
    this.user1 = user1;
    this.user2 = user2;
    this.weight = weight; 
  }
}

public class SocialNetworkApp extends JFrame {

  // Canvas to display graph 
  JPanel canvas = new JPanel();
  
  // HashMap to store nodes
  HashMap<String, User> users = new HashMap<>(); 
  
  // ArrayList to store edges
  ArrayList<Edgee> edges = new ArrayList<>();

  // Construct GUI
  public SocialNetworkApp() {
    
    // Create toolbar buttons
    JToolBar toolbar = new JToolBar();
    JButton addUserButton = new JButton("Add User");
    JButton addEdgeButton = new JButton("Add Edge");
    JButton deleteButton = new JButton("Delete");
    JTextField searchField = new JTextField(10);
    JButton searchButton = new JButton("Search");
    
    toolbar.add(addUserButton);
    toolbar.add(addEdgeButton);
    toolbar.add(deleteButton);
    toolbar.add(searchField);
    toolbar.add(searchButton);
    add(toolbar, BorderLayout.NORTH);
    
    // Add canvas
    add(canvas);
    
    // Read data from file and build graph
    // ...
    
    // Set up button actions
    addUserButton.addActionListener(new AddUserListener());
    addEdgeButton.addActionListener(new AddEdgeListener());
    deleteButton.addActionListener(new DeleteListener());
    searchButton.addActionListener(new SearchListener());
    
  }
  
  // Inner class listeners
  private class AddUserListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Add User");
        
        // User data fields
        JTextField nameField = new JTextField(10);
        JLabel nameLabel = new JLabel("Name:");
        JTextField imageField = new JTextField(15); 
        JLabel imageLabel = new JLabel("Image Path:");
        JSpinner followerSpinner = new JSpinner(new SpinnerNumberModel(0,0,1000,1));
        JLabel followerLabel = new JLabel("Followers:");
        
        // Layout dialog
        JPanel fieldsPanel = new JPanel(new GridLayout(3,2));
        fieldsPanel.add(nameLabel);
        fieldsPanel.add(nameField);
        fieldsPanel.add(imageLabel); 
        fieldsPanel.add(imageField);
        fieldsPanel.add(followerLabel);
        fieldsPanel.add(followerSpinner);
        
        JButton submitBtn = new JButton("Add");
        
        // Add to dialog
        dialog.add(fieldsPanel, BorderLayout.CENTER); 
        dialog.add(submitBtn, BorderLayout.SOUTH);
        
        // Show dialog
        dialog.pack();
        dialog.setVisible(true);
        
        // Get input data
        String name = nameField.getText();
        String imagePath = imageField.getText();
        int followers = (int)followerSpinner.getValue();
        
        // Create new user node
        ImageIcon image = new ImageIcon(imagePath);
        User user = new User(name, image, followers);
        System.out.println(name);
        users.put(name, user);
        
        // Redraw graph
        repaint();
    }
  }
  
  private class AddEdgeListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Open dialog to get edge data and add edge 
    }
  }  

  private class DeleteListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Delete selected node or edge
    }
  }

  private class SearchListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // Search for user and highlight 
    }
  }

  // Paint nodes and edges
  public void paint(Graphics g) {
    // Draw nodes
    for(User user : users.values()) {
        // ImageIcon image = user.getImage(); 
        // image.paintIcon(this, g, x, y);
        
        // // Draw name and followers
        // g.drawString(user.getName(), x + image.getIconWidth() + 5, y);
        // g.drawString("Followers: " + user.getFollowers(), x + image.getIconWidth() + 5, y + 15);
    }
    
    // Draw edges
    for(Edgee edge : edges) {
      // Draw line between nodes
      // Display weight 
    }
  }
  
  public static void main(String[] args) {
    SocialNetworkApp app = new SocialNetworkApp();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setSize(800, 600);
    app.setVisible(true);
  }
}
