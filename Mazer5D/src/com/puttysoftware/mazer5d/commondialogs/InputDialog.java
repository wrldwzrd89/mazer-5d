package com.puttysoftware.mazer5d.commondialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.puttysoftware.images.BufferedImageIcon;

class InputDialog {
    private static MainWindow dialogFrame;
    private static MainWindowContent dialogPane;
    private static CompletableFuture<Integer> completer;

    /**
     * Set up and show the dialog. The first Component argument determines which
     * frame the dialog depends on; it should be a component in the dialog's
     * controlling frame. The second Component argument should be null if you
     * want the dialog to come up with its left corner in the center of the
     * screen; otherwise, it should be the component on top of which the dialog
     * should appear.
     */
    public static Future<Integer> showConfirmDialog(final String labelText,
            final String title, final BufferedImageIcon icon) {
        completer = new CompletableFuture<>();
        Executors.newSingleThreadExecutor().submit(() -> {
            final String[] possibleValues = new String[] { "Yes", "No" };
            initializeDialog(labelText, title, icon, possibleValues);
        });
        return completer;
    }

    public static Future<Integer> showYNCConfirmDialog(final String labelText,
            final String title, final BufferedImageIcon icon) {
        completer = new CompletableFuture<>();
        Executors.newSingleThreadExecutor().submit(() -> {
            final String[] possibleValues = new String[] { "Yes", "No",
                    "Cancel" };
            initializeDialog(labelText, title, icon, possibleValues);
        });
        return completer;
    }

    public static Future<Integer> showDialog(final String labelText,
            final String title, final BufferedImageIcon icon,
            final String[] possibleValues) {
        completer = new CompletableFuture<>();
        Executors.newSingleThreadExecutor().submit(() -> {
            initializeDialog(labelText, title, icon, possibleValues);
        });
        return completer;
    }

    private static void setValue(final int newValue) {
        completer.complete(newValue);
    }

    private static void initializeDialog(final String labelText,
            final String title, final BufferedImageIcon icon,
            final String[] possibleValues) {
        // Create and initialize the dialog.
        dialogFrame = MainWindow.getMainWindow();
        dialogPane = dialogFrame.createContent();
        // main part of the dialog
        final JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        final JLabel label = new JLabel(labelText);
        listPane.add(label);
        listPane.add(Box.createRigidArea(new Dimension(0, 5)));
        listPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Lay out the buttons from left to right.
        final JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(Box.createHorizontalGlue());
        // Create and initialize the buttons.
        for (int i = 0; i < possibleValues.length; i++) {
            final JButton button = new JButton(possibleValues[i]);
            button.setActionCommand(Integer.toString(i));
            button.addActionListener(h -> {
                InputDialog.setValue(Integer.parseInt(h.getActionCommand()));
                dialogFrame.restoreSaved();
            });
            buttonPane.add(button);
            if (i != possibleValues.length - 1) {
                buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
            }
        }
        // Put everything together, using the content pane's BorderLayout.
        dialogPane.add(listPane, BorderLayout.NORTH);
        dialogPane.add(buttonPane, BorderLayout.PAGE_END);
        dialogFrame.attachAndSave(dialogPane);
    }
}
