package moe.hanatomizu.minecraftbackrooms.DataGenerators.providers.languages

import moe.hanatomizu.minecraftbackrooms.objects.ModBlockItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider

class en_us(dataGenerator: FabricDataOutput?) : FabricLanguageProvider(dataGenerator) {
    override fun generateTranslations(translationBuilder: TranslationBuilder) {
        translationBuilder.add(ModBlockItems.ENTRANCE_WALL_ITEM, "Entrance Wall")
        translationBuilder.add(ModBlockItems.ENTRANCE_FLOOR_ITEM, "Entrance Wall")

        translationBuilder.add("itemGroup.backrooms.entrance_blocks", "Backrooms - Entrance Blocks")
    }

}