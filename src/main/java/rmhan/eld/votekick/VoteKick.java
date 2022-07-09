package rmhan.eld.votekick;

import com.ericlam.mc.eld.BukkitManagerProvider;
import com.ericlam.mc.eld.ELDBukkit;
import com.ericlam.mc.eld.ELDBukkitPlugin;
import com.ericlam.mc.eld.ServiceCollection;
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
    }
}
