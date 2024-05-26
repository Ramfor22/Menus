

package org.example;

import javax.swing.SwingUtilities;

public class ControllerView {
    public ControllerView() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartMenu menu = new StartMenu();
            menu.setVisible(true);
        });
    }
}
