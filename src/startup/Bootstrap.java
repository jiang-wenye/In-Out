package startup;
//Æô¶¯³ÌÐò

import javax.swing.SwingUtilities;

import com.gui.jframe.*;
import com.gui.panel.MainPanel;
import com.gui.panel.SpendPanel;
import com.util.GuiUtil;

public class Bootstrap {
	public static void main(String[] args) throws Exception {
		GuiUtil.useLNF();
		
		SwingUtilities.invokeAndWait(new Runnable() {
			
			@Override
			public void run() {
				MainJFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
		});
	}
}
