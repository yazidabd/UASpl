import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class SimulasiUAS {
    private JPanel rootP;
    private JTextField textFieldInput;
    private JButton buttonAdd;
    private JTable tableData;
    private JButton urutkanButton;
    private JTextField textFieldCari;
    private DefaultTableModel tablemodel1;

    public JPanel getRootP(){
        return rootP;
    }

    public SimulasiUAS() {
        this.initComponents();
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nama= textFieldInput.getText();
                if (nama.isEmpty()){
                    JOptionPane.showMessageDialog(rootP,"masukkan nama",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }else
                    tablemodel1.addRow(new Object[]{nama});
                    textFieldInput.setText("");
            }
        });
        textFieldCari.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                super.keyReleased(keyEvent);
                DefaultTableModel Table = (DefaultTableModel) tableData.getModel();
                String search = textFieldCari.getText().toLowerCase();
                TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(Table);
                tableData.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search));
            }
        });
    }

    private void initComponents(){
        Object[] tableColom= {
                "Nama"
        };
        Object[][] iniData={};
        tablemodel1= new DefaultTableModel(iniData, tableColom);
        tableData.setModel(tablemodel1);
        tableData.setAutoCreateRowSorter(true);
        tableData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    public void SearchTextList(String nama) throws SQLException{

    }


}
