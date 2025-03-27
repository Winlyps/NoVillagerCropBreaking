package winlyps.noVillagerCropBreaking

import org.bukkit.plugin.java.JavaPlugin

/**
 * Main plugin class for NoVillagerCropBreaking
 * Prevents villagers from breaking fully grown crops
 */
class NoVillagerCropBreaking : JavaPlugin() {

    override fun onEnable() {
        // Register event listener
        server.pluginManager.registerEvents(CropProtectionListener(this), this)
        logger.info("NoVillagerCropBreaking has been enabled")
    }

    override fun onDisable() {
        logger.info("NoVillagerCropBreaking has been disabled")
    }
}