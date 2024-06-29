/*
* Copyright 2024 Hanatomizu
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package moe.hanatomizu.minecraftbackrooms.world.chunks

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.registry.RegistryEntryLookup
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryOps
import net.minecraft.util.math.BlockPos
import net.minecraft.world.ChunkRegion
import net.minecraft.world.HeightLimitView
import net.minecraft.world.Heightmap
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeKeys
import net.minecraft.world.biome.source.BiomeAccess
import net.minecraft.world.biome.source.FixedBiomeSource
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.StructureAccessor
import net.minecraft.world.gen.chunk.Blender
import net.minecraft.world.gen.chunk.ChunkGenerator
import net.minecraft.world.gen.chunk.VerticalBlockSample
import net.minecraft.world.gen.noise.NoiseConfig
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Function

class EntranceChunkGenerator(biomeRegistry: RegistryEntryLookup<Biome?>) : ChunkGenerator(FixedBiomeSource(biomeRegistry.getOrThrow(BiomeKeys.PLAINS))) {

    companion object {
        val CODEC: Codec<EntranceChunkGenerator?> = RecordCodecBuilder.create<EntranceChunkGenerator?> { instance: RecordCodecBuilder.Instance<EntranceChunkGenerator?> ->
            instance.group(RegistryOps.getEntryLookupCodec(RegistryKeys.BIOME))
                .apply(instance, instance.stable(Function { biomeRegistry: RegistryEntryLookup<Biome?> -> EntranceChunkGenerator(biomeRegistry)}))
        }
    }

    override fun getCodec(): Codec<out ChunkGenerator?> {
        return CODEC
    }

    override fun carve(
        chunkRegion: ChunkRegion?,
        seed: Long,
        noiseConfig: NoiseConfig?,
        biomeAccess: BiomeAccess?,
        structureAccessor: StructureAccessor?,
        chunk: Chunk?,
        carverStep: GenerationStep.Carver?
    ) {

    }

    override fun buildSurface(
        region: ChunkRegion?,
        structures: StructureAccessor?,
        noiseConfig: NoiseConfig?,
        chunk: Chunk?
    ) {

    }

    override fun populateEntities(region: ChunkRegion?) {

    }

    override fun getWorldHeight(): Int {
        return 64
    }

    override fun populateNoise(
        executor: Executor?,
        blender: Blender?,
        noiseConfig: NoiseConfig?,
        structureAccessor: StructureAccessor?,
        chunk: Chunk?
    ): CompletableFuture<Chunk> {
        return CompletableFuture.completedFuture(chunk)
    }

    override fun getSeaLevel(): Int {
        return 0
    }

    override fun getMinimumY(): Int {
        return 0
    }

    override fun getHeight(
        x: Int,
        z: Int,
        heightmap: Heightmap.Type?,
        world: HeightLimitView?,
        noiseConfig: NoiseConfig?
    ): Int {
        return 0
    }

    override fun getColumnSample(
        x: Int,
        z: Int,
        world: HeightLimitView?,
        noiseConfig: NoiseConfig?
    ): VerticalBlockSample {
        return VerticalBlockSample(0, emptyArray())
    }

    override fun getDebugHudText(text: MutableList<String>?, noiseConfig: NoiseConfig?, pos: BlockPos?) {

    }

}