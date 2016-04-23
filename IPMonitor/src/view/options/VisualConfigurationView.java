/*
 * Copyright (C) 2007 - 2010 Gabriel Zanetti
 */
package view.options;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import controller.extras.MessageTypeModel;
import controller.extras.MessageTypeWrapper;
import model.notification.configuration.VisualConfiguration;
import view.extras.JButtonInfo;

public class VisualConfigurationView extends JDialog {
	
    private JButtonInfo jButtonInfo;
    private JComboBox<MessageTypeWrapper> jComboBoxIcons;
    private view.panels.JPanelConfirmation jPanelConfirmation;
    private JTextArea jTextAreaText;
    private JTextField jTextFieldTitle;

    public VisualConfigurationView(JDialog owner) {
        super(owner, true);
        initComponents();
        getRootPane().setDefaultButton(getJButtonOk());
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel jPanelCenter = new JPanel();
        JPanel jPanelCenterBorder = new JPanel();
        JLabel jLabelTitle = new JLabel();
        jTextFieldTitle = new JTextField(VisualConfiguration.getInstance().getTitle(), 25);
        JLabel jLabelText = new JLabel();
        JScrollPane jScrollPaneText = new JScrollPane();
        jTextAreaText = new JTextArea(VisualConfiguration.getInstance().getText());
        jTextAreaText.setFont(jTextFieldTitle.getFont());
        JLabel jLabelIcon = new JLabel();
        MessageTypeModel messageTypeModel = new MessageTypeModel();
        messageTypeModel.setSelectedItem(messageTypeModel.getMessageTypeWrapper(VisualConfiguration.getInstance().getIcon()));
        jComboBoxIcons = new JComboBox<MessageTypeWrapper>(messageTypeModel);
        jButtonInfo = new JButtonInfo();
        jPanelConfirmation = new view.panels.JPanelConfirmation(true, true);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visual notification configuration"); // NOI18N

        jPanelCenterBorder.setBorder(BorderFactory.createTitledBorder("Enter the data to pop up"));

        jLabelTitle.setText("Title:"); // NOI18N

        jTextFieldTitle.setColumns(40);

        jLabelText.setText("Text:"); // NOI18N

        jTextAreaText.setColumns(40);
        jTextAreaText.setRows(10);
        jScrollPaneText.setViewportView(jTextAreaText);

        jLabelIcon.setText("Icon:"); // NOI18N

        GroupLayout jPanelCenterBorderLayout = new GroupLayout(jPanelCenterBorder);
        jPanelCenterBorder.setLayout(jPanelCenterBorderLayout);
        jPanelCenterBorderLayout.setHorizontalGroup(
            jPanelCenterBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterBorderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCenterBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle)
                    .addComponent(jLabelText)
                    .addComponent(jLabelIcon))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCenterBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTitle)
                    .addComponent(jScrollPaneText)
                    .addGroup(jPanelCenterBorderLayout.createSequentialGroup()
                        .addComponent(jComboBoxIcons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(jButtonInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelCenterBorderLayout.setVerticalGroup(
            jPanelCenterBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterBorderLayout.createSequentialGroup()
                .addGroup(jPanelCenterBorderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jTextFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCenterBorderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelText)
                    .addComponent(jScrollPaneText, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCenterBorderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIcon)
                    .addComponent(jComboBoxIcons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        GroupLayout jPanelCenterLayout = new GroupLayout(jPanelCenter);
        jPanelCenter.setLayout(jPanelCenterLayout);
        jPanelCenterLayout.setHorizontalGroup(
            jPanelCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCenterBorder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCenterLayout.setVerticalGroup(
            jPanelCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCenterBorder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelCenter, BorderLayout.CENTER);
        getContentPane().add(jPanelConfirmation, BorderLayout.SOUTH);

        pack();
    }

    public JTextField getJTextFieldTitle() {
        return jTextFieldTitle;
    }

    public JTextArea getJTextAreaText() {
        return jTextAreaText;
    }

    public JComboBox<MessageTypeWrapper> getJComboBoxIcons() {
        if (jComboBoxIcons == null) {
            MessageTypeModel messageTypeModel = new MessageTypeModel();
            messageTypeModel.setSelectedItem(messageTypeModel.getMessageTypeWrapper(VisualConfiguration.getInstance().getIcon()));
            jComboBoxIcons = new JComboBox<MessageTypeWrapper>(messageTypeModel);
        }
        return jComboBoxIcons;
    }

    public JButton getJButtonInfo() {
        return jButtonInfo;
    }

    public JButton getJButtonApply() {
        return jPanelConfirmation.getJButtonApply();
    }

    public JButton getJButtonOk() {
        return jPanelConfirmation.getJButtonOk();
    }

    public JButton getJButtonCancel() {
        return jPanelConfirmation.getJButtonCancel();
    }
}
