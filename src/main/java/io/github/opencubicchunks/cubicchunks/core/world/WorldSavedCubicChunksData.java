/*
 *  This file is part of CubicChunks, licensed under the MIT License (MIT).
 *
 *  Copyright (c) 2015-2019 OpenCubicChunks
 *  Copyright (c) 2015-2019 contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package io.github.opencubicchunks.cubicchunks.core.world;

import io.github.opencubicchunks.cubicchunks.api.util.Coords;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.storage.WorldSavedData;

public class WorldSavedCubicChunksData extends WorldSavedData {

    public boolean isCubicChunks = false;
    public int minHeight = 0, maxHeight = 256;

    public WorldSavedCubicChunksData() {
        super("cubicChunksData");
    }

    public WorldSavedCubicChunksData(boolean isCC) {
        this();
        if (isCC) {
            minHeight = Coords.MIN_BLOCK_Y;
            maxHeight = Coords.MAX_BLOCK_Y;
            isCubicChunks = true;
        }
    }

    @Override
    public void read(CompoundNBT nbt) {
        minHeight = nbt.getInt("minHeight");
        maxHeight = nbt.getInt("maxHeight");
        isCubicChunks = !nbt.contains("isCubicChunks") || nbt.getBoolean("isCubicChunks");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("minHeight", minHeight);
        compound.putInt("maxHeight", maxHeight);
        compound.putBoolean("isCubicChunks", isCubicChunks);
        return compound;
    }

}
