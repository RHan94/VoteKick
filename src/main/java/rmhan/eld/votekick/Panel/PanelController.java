package rmhan.eld.votekick.Panel;

import com.ericlam.mc.eldgui.controller.UIController;
import com.ericlam.mc.eldgui.event.ClickMapping;
import com.ericlam.mc.eldgui.view.BukkitView;
import org.bukkit.entity.Player;
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
    @ClickMapping(pattern = 'A', view = PanelView.class)
    public void onClickA(Player player) {
        player.performCommand("vk yes");
    }

    @ClickMapping(pattern = 'D', view = PanelView.class)
    public void onClickD(Player player) {
        player.performCommand("vk no");
    }
}
