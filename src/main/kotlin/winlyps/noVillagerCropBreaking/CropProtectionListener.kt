package winlyps.noVillagerCropBreaking

import org.bukkit.Material
import org.bukkit.block.data.Ageable
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityChangeBlockEvent

class CropProtectionListener(private val plugin: NoVillagerCropBreaking) : Listener {

    private val cropMaterials = setOf(
            Material.WHEAT,
            Material.CARROTS,
            Material.POTATOES,
            Material.BEETROOTS
    )

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onEntityChangeBlock(event: EntityChangeBlockEvent) {
        if (event.entityType != EntityType.VILLAGER) {
            return
        }

        val block = event.block

        if (!cropMaterials.contains(block.type)) {
            return
        }

        val blockData = block.blockData
        if (blockData is Ageable && blockData.age == blockData.maximumAge) {
            event.isCancelled = true
            plugin.logger.fine("Prevented villager from breaking a fully grown ${block.type.name} at ${block.location}")
        }
    }
}