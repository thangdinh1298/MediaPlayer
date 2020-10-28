import entites.LivestreamInfo;
import net.HttpHandler;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class M {
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTable streamTable;
    private JButton getStreamsButton;

    public M() {

        getStreamsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                ArrayList<LivestreamInfo> lives = HttpHandler.GetRooms();
//
//                LiveStreamsTableModel model = new LiveStreamsTableModel();
//                for (LivestreamInfo l: lives) {
//                    model.addRow(l.getRoomName(), l.getViewerCount());
//                }
//
//                streamTable.setModel(model);
                tabbedPane1.setSelectedIndex(1);
            }
        });

        streamTable.setModel(new LiveStreamsTableModel());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


    class LiveStreamsTableModel extends AbstractTableModel {
        private String[] columnNames = {"Room",  "Number of viewers"};
        private final Class<?>[] columnTypes = new  Class<?>[] {String.class, Integer.class};
        private ArrayList<LivestreamInfo> rows = new ArrayList<>();

        void addRow(String roomName, Integer viewerCount) {
            rows.add(new LivestreamInfo(roomName, viewerCount));
        }

        @Override public int getColumnCount() {
            return columnNames.length;
        }

        @Override public int getRowCount() {
            return this.rows.size();
        }

        @Override public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }

        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return rows.get(rowIndex).getRoomName();
                case 1:
                    return rows.get(rowIndex).getViewerCount();
                default:
                    return "Error";
            }

        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
}
