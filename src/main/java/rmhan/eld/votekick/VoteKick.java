package rmhan.eld.votekick;

import com.ericlam.mc.eld.BukkitManagerProvider;
import com.ericlam.mc.eld.ELDBukkit;
import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ServiceCollection;
import com.ericlam.mc.eldgui.MVCInstallation;
import rmhan.eld.votekick.LogPanel.LogPanelController;
import rmhan.eld.votekick.LogPanel.LogPanelView;
import rmhan.eld.votekick.Logs.VoteLog;
import rmhan.eld.votekick.VotePanel.PanelController;

@ELDBukkit(
        registry = Registry.class,
        lifeCycle = LifeCycle.class
)
public final class VoteKick extends ELDBukkitPlugin {


    @Override
    protected void manageProvider(BukkitManagerProvider bukkitManagerProvider) {

    }

    @Override
    public void bindServices(ServiceCollection serviceCollection) {
        serviceCollection.addSingleton(KickManager.class);
        serviceCollection.addConfiguration(KickConfig.class);
        serviceCollection.addGroupConfiguration(VoteLog.class);
        MVCInstallation mvc = serviceCollection.getInstallation(MVCInstallation.class);
        mvc.registerControllers(PanelController.class);
        mvc.registerControllers(LogPanelController.class);
    }
}
