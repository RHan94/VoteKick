package rmhan.eld.votekick.VotePanel;

import com.ericlam.mc.eldgui.component.factory.ButtonFactory;
import com.ericlam.mc.eldgui.view.UIContext;
import com.ericlam.mc.eldgui.view.View;
import com.ericlam.mc.eldgui.view.ViewDescriptor;
import org.bukkit.Material;

@ViewDescriptor(
        name = "投票頁面",
        rows = 3,
        patterns = {"ZZZZIZZZZ","ZAZZZZZDZ","ZZZZZZZZZ"},
        cancelMove = {'I','A','D'}
)

public class PanelView implements View<String>{
    @Override
    public void renderView(String model, UIContext context) {
        ButtonFactory button = context.factory(ButtonFactory.class); // Button 是展示類組件
        context.pattern('I')
                .components(
                        button.icon(Material.PLAYER_HEAD)
                                .title("§e投票資訊")
                                .lore(model.split("\n"))
                                .create()
                );
        context.pattern('A')
                .components(
                    button.icon(Material.GREEN_STAINED_GLASS_PANE)
                        .title("§a同意")
                        .create()
        );
        context.pattern('D')
                .components(
                        button.icon(Material.RED_STAINED_GLASS_PANE)
                                .title("§c不同意")
                                .create()
                );
    }
}