import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OXForm {
    private JLabel lblScoreX;
    private JLabel lblScoreDraw;
    private JLabel lblScoreO;
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private OX ox;
    private int col,row;

    public OXForm() {
        ox = new OX();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 0;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 0;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 0;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 1;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 1;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 1;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 0;
                row = 2;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 1;
                row = 2;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = 2;
                row = 2;
                if(ox.put(col,row)){
                    render();
                    process();
                }
            }
        });
    }

    private void process() {
        if(ox.checkWin(col,row)){
            int result = JOptionPane.showConfirmDialog(null,ox.getCurrentPlayer()+" WIN,"+
                    "Do you want to play again","WIN",JOptionPane.YES_OPTION);
            if(result == JOptionPane.YES_OPTION){
                ox. reset();
                render();
                return;
            }else{
                System.exit(0);
                render();
                return;
            }
        }else if(ox.isDraw()){
            System.exit(0);
            int result = JOptionPane.showConfirmDialog(null,ox.getCurrentPlayer()+" Draw,"+
                    "Do you want to play again","Draw",JOptionPane.YES_OPTION);


        }
        ox.switchPlayer();
    }

    private void render() {
        button1.setText(ox.get(0,0));
        button2.setText(ox.get(1,0));
        button3.setText(ox.get(2,0));
        button4.setText(ox.get(0,1));
        button5.setText(ox.get(1,1));
        button6.setText(ox.get(2,1));
        button7.setText(ox.get(0,2));
        button8.setText(ox.get(1,2));
        button9.setText(ox.get(2,2));
        lblScoreX.setText("X : "+ox.getScoreX());
        lblScoreDraw.setText("Draw : "+ox.getScoreDraw());
        lblScoreO.setText("O : "+ox.getScoreO());


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        OXForm form = new OXForm();
        frame.setContentPane(form.mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setVisible(true);
    }
}
