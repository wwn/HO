package tool.iconsDecorator;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.gui.theme.ImageUtilities;
import core.gui.theme.HOIconName;
import core.gui.theme.ThemeManager;
import core.model.HOVerwaltung;

public class IconsDecoratorDialog extends JDialog implements ActionListener{

    private JPanel toolbar;
    private JComboBox jcbThemeSelector;
    private DarculaTheme toto = new DarculaTheme();
    LafManager.g
    var aa = toto.getDefaults();

    if themeName == "Darcula":
            label.setBackground(XXX("darcula").getColor(HOColorName.TABLEENTRY_BG));


    public IconsDecoratorDialog(JFrame owner){
        super(owner, true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initialize();
    }

    private void initialize() {
        setSize(900,430);
        setLayout(new BorderLayout());
        setTitle(HOVerwaltung.instance().getLanguageString("menu.tools.iconsDecorator"));

        // create toolbar
        toolbar = new JPanel(new FlowLayout(FlowLayout.LEADING));
        jcbThemeSelector = new JComboBox(ThemeManager.instance().getRegisteredThemesNames().toArray());
        jcbThemeSelector.addActionListener(this);
        toolbar.add(jcbThemeSelector);

        add(toolbar, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout());
        Icon icon = ImageUtilities.getSvgIcon(HOIconName.GOAL);
        JLabel label = new JLabel(ImageUtilities.getScaledIcon(icon, 100, 100));
        label.setBackground();

        mainPanel.add(label);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(mainPanel,BorderLayout.CENTER);

    }



    @Override
    public void actionPerformed(ActionEvent e) {}



}
