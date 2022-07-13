package rmhan.eld.votekick.Panel;

import com.ericlam.mc.eldgui.controller.UIController;
import com.ericlam.mc.eldgui.view.BukkitView;
import rmhan.eld.votekick.KickManager;

import javax.inject.Inject;

@UIController("VotePage")
public class PanelController {
    @Inject
    private KickManager kickManager;
    public BukkitView<?, ?> index() {
        String greeting = kickManager.getInfo();
        return new BukkitView<>(PanelView.class, greeting);
    }
}
