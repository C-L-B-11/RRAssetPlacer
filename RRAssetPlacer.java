import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RRAssetPlacer{

    JTextField x;
    JTextField y;
    JTextField z;
    public static void main(String args[]){
        new RRAssetPlacer();
    }

    RRAssetPlacer(){
        JFrame mainFrame = new JFrame("RRAssetPlacer");
        mainFrame.setSize(550,750);
        mainFrame.setBackground(Color.DARK_GRAY);
        mainFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS ));

        JPanel p1 = panel1();
        JPanel p2 = panelDir("Parameters of first movement axis",0,mainPanel);
        JPanel p3 = panelDir("Parameters of second movement axis",1,mainPanel);
        JPanel p4 = panelRes(mainPanel);
        

        mainPanel.add(p1,0);
        mainPanel.add(p2,1);
        mainPanel.add(p3,2);
        mainPanel.add(p4,3);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private JPanel panel1(){
    
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new javax.swing.BoxLayout(
            panel, javax.swing.BoxLayout.Y_AXIS ));

        JLabel lHead = new JLabel("Parameters of the first asset",JLabel.CENTER);
            lHead.setVerticalAlignment(JLabel.CENTER);
            lHead.setHorizontalTextPosition(JLabel.CENTER);
        panel.add(lHead,0);

        JPanel pPos = new JPanel();
            JLabel lPos = new JLabel("Position:");
            JLabel lPX = new JLabel("x:");
            JTextField tfPX = new JTextField("0",8);
            JLabel lPY = new JLabel("y:");
            JTextField tfPY = new JTextField("0",8);
            JLabel lPZ = new JLabel("z:");
            JTextField tfPZ = new JTextField("0",8);
            pPos.add(lPos,0);
            pPos.add(lPX,1);
            pPos.add(tfPX,2);
            pPos.add(lPY,3);
            pPos.add(tfPY,4);
            pPos.add(lPZ,5);
            pPos.add(tfPZ,6);
            x=tfPX;
            y=tfPY;
            z=tfPZ;
        panel.add(pPos,1);

        JPanel pRePos = new JPanel();
            JLabel lRePos = new JLabel("Read Position from json");
            JTextField tfRePos = new JTextField("\"position\":{\"x\": 1.0, \"y\": 1.0, \"z\": 1.0}",20);
            JButton bRePos = new JButton("Read");
            bRePos.addActionListener((ActionEvent e) -> {
                try{
                    x.setText(Double.toString(jsonToDouble(tfRePos.getText(), 'x')));
                    y.setText(Double.toString(jsonToDouble(tfRePos.getText(), 'y')));
                    z.setText(Double.toString(jsonToDouble(tfRePos.getText(), 'z')));
                }
                catch(Exception ex){
                    Error(new Exception(ex.toString()+"@Read Position from json"));
                }
            });
            pRePos.add(lRePos);
            pRePos.add(tfRePos);
            pRePos.add(bRePos);
        panel.add(pRePos,2);

        JPanel pRot = new JPanel();
            JLabel lRot = new JLabel("Rotation:");
            JLabel lRX = new JLabel("x:");
            JTextField tfRX = new JTextField("0",8);
            JLabel lRY = new JLabel("y:");
            JTextField tfRY = new JTextField("0",8);
            JLabel lRZ = new JLabel("z:");
            JTextField tfRZ = new JTextField("0",8);
            pRot.add(lRot,0);
            pRot.add(lRX,1);
            pRot.add(tfRX,2);
            pRot.add(lRY,3);
            pRot.add(tfRY,4);
            pRot.add(lRZ,5);
            pRot.add(tfRZ,6);
        panel.add(pRot,3);

        JPanel pReRot = new JPanel();
            JLabel lReRot = new JLabel("Read Rotation from json");
            JTextField tfReRot = new JTextField("\"rotation\":{\"x\": 1.0, \"y\": 1.0, \"z\": 1.0}",20);
            JButton bReRot = new JButton("Read");
            bReRot.addActionListener((ActionEvent e) -> {
                try{
                    tfRX.setText(Double.toString(jsonToDouble(tfReRot.getText(), 'x')));
                    tfRY.setText(Double.toString(jsonToDouble(tfReRot.getText(), 'y')));
                    tfRZ.setText(Double.toString(jsonToDouble(tfReRot.getText(), 'z')));
                }
                catch(Exception ex){
                    Error(new Exception(ex.toString()+"@Read Rotation from json"));
                }
            });
            pReRot.add(lReRot);
            pReRot.add(tfReRot);
            pReRot.add(bReRot);
        panel.add(pReRot,4);

        JPanel pSc = new JPanel();
            JLabel lSc = new JLabel("Scale:");
            JLabel lSX = new JLabel("x:");
            JTextField tfSX = new JTextField("1",8);
            JLabel lSY = new JLabel("y:");
            JTextField tfSY = new JTextField("1",8);
            JLabel lSZ = new JLabel("z:");
            JTextField tfSZ = new JTextField("1",8);
            pSc.add(lSc,0);
            pSc.add(lSX,1);
            pSc.add(tfSX,2);
            pSc.add(lSY,3);
            pSc.add(tfSY,4);
            pSc.add(lSZ,5);
            pSc.add(tfSZ,6);
        panel.add(pSc,5);

        JPanel pReSc = new JPanel();
            JLabel lReSc = new JLabel("Read Scale from json");
            JTextField tfReSc = new JTextField("\"scale\":{\"x\": 1.0, \"y\": 1.0, \"z\": 1.0}",20);
            JButton bReSc = new JButton("Read");
            bReSc.addActionListener((ActionEvent e) -> {
                try{
                    tfSX.setText(Double.toString(jsonToDouble(tfReSc.getText(), 'x')));
                    tfSY.setText(Double.toString(jsonToDouble(tfReSc.getText(), 'y')));
                    tfSZ.setText(Double.toString(jsonToDouble(tfReSc.getText(), 'z')));
                }
                catch(Exception ex){
                    Error(new Exception(ex.toString()+"@Read Scale from json"));
                }
            });
            pReSc.add(lReSc);
            pReSc.add(tfReSc);
            pReSc.add(bReSc);
        panel.add(pReSc,6);

        JPanel pMI = new JPanel();
            JLabel lMI = new JLabel("Model Identifier:");
            JTextField tfMI = new JTextField("\"Barn\"",20);
            pMI.add(lMI,0);
            pMI.add(tfMI,1);
        panel.add(pMI,7);
        
        JPanel pUN = new JPanel();
            JLabel lUN = new JLabel("Unique Name:");
            JTextField tfUN = new JTextField("Barn_",20);
            pUN.add(lUN,0);
            pUN.add(tfUN,1);
        panel.add(pUN,8);
        
        JPanel pSI = new JPanel();
            JLabel lSI = new JLabel("Start Index:");
            JTextField tfSI = new JTextField("0",3);
            pSI.add(lSI,0);
            pSI.add(tfSI,1);
        panel.add(pSI,9);


        return panel;
    }
    
    private JPanel panelDir(String head,int mode,JPanel mainPanel){
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new javax.swing.BoxLayout(
            panel, javax.swing.BoxLayout.Y_AXIS ));

        JLabel lHead = new JLabel(head,JLabel.CENTER);
            lHead.setVerticalAlignment(JLabel.CENTER);
            lHead.setHorizontalTextPosition(JLabel.CENTER);
        panel.add(lHead,0);

        JPanel pMov = new JPanel();
            JLabel lMov = new JLabel("Direction:");
            JLabel lMX = new JLabel("x:");
            JTextField tfMX = new JTextField("1",8);
            JLabel lMY = new JLabel("y:");
            JTextField tfMY = new JTextField("0",8);
            JLabel lMZ = new JLabel("z:");
            JTextField tfMZ = new JTextField("0",8);
            pMov.add(lMov,0);
            pMov.add(lMX,1);
            pMov.add(tfMX,2);
            pMov.add(lMY,3);
            pMov.add(tfMY,4);
            pMov.add(lMZ,5);
            pMov.add(tfMZ,6);
        panel.add(pMov,1);

        JPanel pMU = new JPanel();
            JButton bUS = new JButton("Scale to Unit");
            JLabel lTU = new JLabel("Direction Scaler:");
            JTextField tfTU = new JTextField("1",5);
            JLabel lTD = new JLabel("Repetitions:");
            JTextField tfTD = new JTextField("1",2);
            bUS.addActionListener((ActionEvent e) -> {
                try{
                    JTextField tx = (JTextField) pMov.getComponent(2);
                    JTextField ty = (JTextField) pMov.getComponent(4);
                    JTextField tz = (JTextField) pMov.getComponent(6);
                    double X = StrToDouble(tx.getText());
                    double Y = StrToDouble(ty.getText());
                    double Z = StrToDouble(tz.getText());
                    double factor = Math.sqrt(X*X+Y*Y+Z*Z);
                    tx.setText(Double.toString(X/factor));
                    ty.setText(Double.toString(Y/factor));
                    tz.setText(Double.toString(Z/factor));
                    
                }
                catch(Exception ex){
                    Error(new Exception(ex.toString()+"@Scale to Unit"));
                }
            });
            pMU.add(bUS,0);
            pMU.add(lTU,1);
            pMU.add(tfTU,2);
            pMU.add(lTD,3);
            pMU.add(tfTD,4);
        panel.add(pMU,2);

        JPanel pCPV = new JPanel();
        JButton bATV = new JButton("Add to f.A. pos.");
            bATV.addActionListener((ActionEvent e) -> {
                try {
                    x.setText(Double.toString(StrToDouble(x.getText())+StrToDouble(tfMX.getText())*StrToDouble(tfTU.getText())));
                    y.setText(Double.toString(StrToDouble(y.getText())+StrToDouble(tfMY.getText())*StrToDouble(tfTU.getText())));
                    z.setText(Double.toString(StrToDouble(z.getText())+StrToDouble(tfMZ.getText())*StrToDouble(tfTU.getText())));
                }
                catch (Exception ex) {
                    Error(new Exception(ex.toString()+"@Add to Origin"));
                }
            });
            pCPV.add(bATV,0);
        if(mode==0){
            JButton bCFA = new JButton("Copy from f.A.");
            bCFA.addActionListener((ActionEvent e) -> {
                tfMX.setText(x.getText());
                tfMY.setText(y.getText());
                tfMZ.setText(z.getText());
            });
            pCPV.add(bCFA,1);
            JButton bDFA = new JButton("Difference from f.A.");
            bDFA.addActionListener((ActionEvent e) -> {
                
                try {
                    tfMX.setText(Double.toString(StrToDouble(x.getText())-StrToDouble(tfMX.getText())));
                    tfMY.setText(Double.toString(StrToDouble(y.getText())-StrToDouble(tfMY.getText())));
                    tfMZ.setText(Double.toString(StrToDouble(z.getText())-StrToDouble(tfMZ.getText())));
                } catch (Exception ex) {
                    Error(new Exception(ex.toString()+"@Difference from Asset"));
                }
                
            });
            pCPV.add(bDFA,2);
            JButton bAFA = new JButton("Angle from f.A.");
            bAFA.addActionListener((ActionEvent e) -> {
                double rot =0;
                try {
                    rot= StrToDouble(((JTextField)(((JPanel)(((JPanel)(mainPanel.getComponent(0))).getComponent(3))).getComponent(4))).getText());
                }
                catch (Exception ex) {
                    Error(new Exception(ex.toString()+"@Angle from Asset"));
                }
                rot = Math.toRadians(rot);
                tfMX.setText(Double.toString(Math.sin(rot)));
                tfMY.setText("0");
                tfMZ.setText(Double.toString(Math.cos(rot)));
                if(Math.abs(Math.sin(rot))<0.000001){tfMX.setText("0");}
                if(Math.abs(Math.cos(rot))<0.000001){tfMZ.setText("0");}
            });
            pCPV.add(bAFA,3);
        }
        else if(mode==1){
            JButton bCPV = new JButton("Calculate perpendicular to first axis");
            bCPV.addActionListener((ActionEvent e) -> {
                try {
                    JTextField tfmX = (JTextField)((JPanel)((JPanel)mainPanel.getComponent(1)).getComponent(1)).getComponent(2);
                    JTextField tfmZ = (JTextField)((JPanel)((JPanel)mainPanel.getComponent(1)).getComponent(1)).getComponent(6);
                    tfMX.setText(Double.toString(-StrToDouble(tfmZ.getText())));
                    tfMZ.setText(tfmX.getText());
                }
                catch (Exception ex) {
                    Error(new Exception(ex.toString()+"@Calculate perpendicular to first"));
                }
            });
            pCPV.add(bCPV,1);
        }
        panel.add(pCPV,3);
        return panel;
    }
    
    private JPanel panelRes(JPanel mainPanel){
        JPanel panel= new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new javax.swing.BoxLayout(
            panel, javax.swing.BoxLayout.Y_AXIS ));

        JLabel lHead = new JLabel("Result",JLabel.CENTER);
            lHead.setVerticalAlignment(JLabel.CENTER);
            lHead.setHorizontalTextPosition(JLabel.CENTER);
        panel.add(lHead,0);

        JPanel pRes1 = new JPanel();
            JButton bMake = new JButton("Make json");
            bMake.addActionListener((ActionEvent e) -> {
                try{
                    generateAssets(mainPanel);
                }
                catch(Exception ex){
                    Error(new Exception(ex.toString()+"@Make json"));
                }
            });
            JButton bAddSI = new JButton("Add to Start Index");
            bAddSI.addActionListener((ActionEvent e) -> {
                try{
                    addToStartIndex(mainPanel);
                }
                catch(Exception ex){
                    Error(new Exception(ex.toString()+"@Add to Start Index"));
                }
            });
            pRes1.add(bMake,0);
            pRes1.add(bAddSI,1);
        
        

        JPanel pRes2 = new JPanel();
            JTextArea ta = new JTextArea(5,30);
            pRes2.add(ta,0);

        panel.add(lHead,0);
        panel.add(pRes1,1);
        panel.add(pRes2,2);

        return panel;
    }

    private static double StrToDouble(String string) throws Exception{
        double f=0;
        double dec=0;
        int decCount=0;
        boolean frac=false;
        if(string.length()==0){
            throw new Exception("Error while trying to parse a number: Empty Field");
        }
        for(int i=0;i<string.length();i++){
            char c=string.charAt(i);
            if(c=='.'){
                frac=true;
                
            }
            else if(c>=48&&c<58){
                if(!frac){
                    f*=10;
                    f+=c-48;
                }
                else{
                    dec*=10;
                    dec+=c-48;
                    decCount++;
                }
                
            }
            else if(c!='-'){
                throw new Exception("Error while trying to parse a number: Invalid Character");
            }
        }
        while(decCount-->0){
            dec*=0.1;
        }
        f+=dec;
        if(string.charAt(0)=='-'){f*=-1;}
        return f;
    }

    private static double jsonToDouble(String string, char parameter) throws Exception{
        int startIndex=-1;
        int endIndex;
        int state=0;
        for(int i=0;i<string.length();i++){
            char c=string.charAt(i);
            switch (state){
                case 0 -> {
                    if(c==parameter){
                        state=1;
                    }
                }
                case 1 -> {
                    if(c==45||(c>=48&&c<58)){
                        startIndex=i;
                        state=2;
                    }
                }
                case 2 -> {
                    if(!(c>=48&&c<58)&&c!=46){
                        endIndex=i;
                        return StrToDouble(string.substring(startIndex, endIndex));
                    }
                }
            }
            
        }
        throw new Exception("Coudn't parse Parameter "+parameter);
        
    }

    private static String generateAsset(String Name,String Identifier,double XPos,double YPos,double ZPos,double XRot,double YRot,double ZRot,double XSc,double YSc,double ZSc){
        String s="\"";
            s+=Name;
            s+="\":{\n";
            s+="\"position\":{\"x\": ";
            s+=Double.toString(XPos);
            s+=",\"y\": ";
            s+=Double.toString(YPos);
            s+=",\"z\": ";
            s+=Double.toString(ZPos);
            s+="},\n";

            s+="\"rotation\":{\"x\": ";
            s+=Double.toString(XRot);
            s+=",\"y\": ";
            s+=Double.toString(YRot);
            s+=",\"z\": ";
            s+=Double.toString(ZRot);
            s+="},\n";

            s+="\"scale\":{\"x\": ";
            s+=Double.toString(XSc);
            s+=",\"y\": ";
            s+=Double.toString(YSc);
            s+=",\"z\": ";
            s+=Double.toString(ZSc);
            s+="},\n";

            s+="\"modelIdentifier\": ";
            s+=Identifier;
            s+="\n}";
        return s;
    }

    private void generateAssets(JPanel mainPanel) throws Exception{
        JPanel p1 = (JPanel)mainPanel.getComponent(0);
        JPanel p2 = (JPanel)mainPanel.getComponent(1);
        JPanel p3 = (JPanel)mainPanel.getComponent(2);
        JPanel p4 = (JPanel)mainPanel.getComponent(3);

        JPanel pRot = (JPanel)p1.getComponent(3);
        JPanel pSc = (JPanel)p1.getComponent(5);

        JPanel pM11 = (JPanel)p2.getComponent(1);
        JPanel pM12 = (JPanel)p2.getComponent(2);
        JPanel pM21 = (JPanel)p3.getComponent(1);
        JPanel pM22 = (JPanel)p3.getComponent(2);

        double XPos; double YPos; double ZPos;
        try{XPos = StrToDouble(x.getText());YPos = StrToDouble(y.getText());ZPos = StrToDouble(z.getText());}
        catch(Exception ex){throw new Exception(ex.toString()+"@First Asset Position");}

        double XRot;double YRot;double ZRot;
        try{XRot = StrToDouble(((JTextField)pRot.getComponent(2)).getText());
            YRot = StrToDouble(((JTextField)pRot.getComponent(4)).getText());
            ZRot = StrToDouble(((JTextField)pRot.getComponent(6)).getText());}
        catch(Exception ex){throw new Exception(ex.toString()+"@First Asset Rotation");}
        
        double XSc; double YSc; double ZSc;
        try{XSc = StrToDouble(((JTextField)pSc.getComponent(2)).getText());
            YSc = StrToDouble(((JTextField)pSc.getComponent(4)).getText());
            ZSc = StrToDouble(((JTextField)pSc.getComponent(6)).getText());}
        catch(Exception ex){throw new Exception(ex.toString()+"@First Asset Scale");}

        double XM1; double YM1; double ZM1;
        try{XM1 = StrToDouble(((JTextField)pM11.getComponent(2)).getText());
            YM1 = StrToDouble(((JTextField)pM11.getComponent(4)).getText());
            ZM1 = StrToDouble(((JTextField)pM11.getComponent(6)).getText());}
        catch(Exception ex){throw new Exception(ex.toString()+"@First Movement Direction");}

        double XM2; double YM2; double ZM2;
        try{XM2 = StrToDouble(((JTextField)pM21.getComponent(2)).getText());
            YM2 = StrToDouble(((JTextField)pM21.getComponent(4)).getText());
            ZM2 = StrToDouble(((JTextField)pM21.getComponent(6)).getText());}
        catch(Exception ex){throw new Exception(ex.toString()+"@Second Movement Direction");}

        double ScM1; double ScM2;
        try{ScM1 = StrToDouble(((JTextField)pM12.getComponent(2)).getText());
            ScM2 = StrToDouble(((JTextField)pM22.getComponent(2)).getText());}
        catch(Exception ex){throw new Exception(ex.toString()+"@Direction Scaler");}

        int ReM1; int ReM2;
        try{ReM1 = (int)StrToDouble(((JTextField)pM12.getComponent(4)).getText());
            ReM2 = (int)StrToDouble(((JTextField)pM22.getComponent(4)).getText());}
        catch(Exception ex){throw new Exception(ex.toString()+"@Repetitions");}

        String id = ((JTextField)((JPanel)p1.getComponent(7)).getComponent(1)).getText();
        String na = ((JTextField)((JPanel)p1.getComponent(8)).getComponent(1)).getText();
        int si=0;
        try{
            si = (int)StrToDouble(((JTextField)((JPanel)p1.getComponent(9)).getComponent(1)).getText());
            if(si<0)si=0;}
        catch(Exception ex){throw new Exception(ex.toString()+"@StartIndex");}

        XM1*=ScM1;
        YM1*=ScM1;
        ZM1*=ScM1;
        XM2*=ScM2;
        YM2*=ScM2;
        ZM2*=ScM2;

        int n=0;
        String s="";
        for(int i=0;i<ReM1;i++){
            for(int j=0;j<ReM2;j++){
                if(n!=0){s+=",\n";}
                s+=generateAsset(na+dec(n+si), id, XPos+i*XM1+j*XM2, YPos+i*YM1+j*YM2, ZPos+i*ZM1+j*ZM2, XRot, YRot, ZRot, XSc, YSc, ZSc);
                n++;
            }
        }
        ((JTextArea)((JPanel)p4.getComponent(2)).getComponent(0)).setText(s);
    }
    
    private void addToStartIndex(JPanel mainPanel) throws Exception{
        
        int ReM1; int ReM2;
        try{ReM1 = (int)StrToDouble(((JTextField)((JPanel)((JPanel)mainPanel.getComponent(1)).getComponent(2)).getComponent(4)).getText());
            ReM2 = (int)StrToDouble(((JTextField)((JPanel)((JPanel)mainPanel.getComponent(2)).getComponent(2)).getComponent(4)).getText());}
        catch(Exception ex){throw new Exception(ex.toString()+"@Repetitions");}
        
        JTextField tfSI = (JTextField)(((JPanel)((JPanel)mainPanel.getComponent(0)).getComponent(9)).getComponent(1));
        
        int si=0;
        try{
            si = (int)StrToDouble((tfSI).getText());
            if(si<0)si=0;}
        catch(Exception ex){throw new Exception(ex.toString()+"@StartIndex");}
        
        tfSI.setText(Integer.toString(si+(ReM1*ReM2)));
    }

    private static String dec(int n){
        String s="";
        if(n<100){s+="0";}
        if(n<10){s+="0";}
        s+=Integer.toString(n);
        return s;
    }

    private void Error(Exception ex){
        JTextArea ta = new JTextArea(5,30);
        ta.setText(ex.toString());
        ta.setEditable(false);
        ta.setLineWrap(true);
        JOptionPane.showMessageDialog(new JFrame() ,new JScrollPane(ta),"Ergebnis",JOptionPane.ERROR_MESSAGE);
    }
}

