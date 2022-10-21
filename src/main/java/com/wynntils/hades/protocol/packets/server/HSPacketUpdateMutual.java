package com.wynntils.hades.protocol.packets.server;

import com.wynntils.hades.protocol.interfaces.HadesPacket;
import com.wynntils.hades.protocol.interfaces.adapters.IHadesClientAdapter;
import com.wynntils.hades.utils.HadesBuffer;

import java.util.UUID;

/**
 * Used for updating mutual friends/party users their status.
 */
public class HSPacketUpdateMutual implements HadesPacket<IHadesClientAdapter> {
    UUID user;
    String name;
    float x, y, z;
    int health, mana;
    int maxHealth, maxMana;
    String world;
    boolean isMutualFriend;
    boolean isMutualPartyMember;
    boolean isMutualGuildMember;

    public HSPacketUpdateMutual() { }

    public HSPacketUpdateMutual(UUID user, String name, float x, float y, float z, int health, int mana, int maxHealth, int maxMana, String world, boolean isMutualFriend, boolean isMutualPartyMember, boolean isMutualGuildMember) {
        this.user = user;
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.health = health;
        this.maxHealth = maxHealth;
        this.mana = mana;
        this.maxMana = maxMana;
        this.world = world;
        this.isMutualFriend = isMutualFriend;
        this.isMutualPartyMember = isMutualPartyMember;
        this.isMutualGuildMember = isMutualGuildMember;
    }

    public UUID getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public String getWorld() {
        return world;
    }

    public boolean isMutualFriend() {
        return isMutualFriend;
    }

    public boolean isMutualGuildMember() {
        return isMutualGuildMember;
    }

    public boolean isMutualPartyMember() {
        return isMutualPartyMember;
    }

    @Override
    public void readData(HadesBuffer buffer) {
        user = buffer.readUUID();
        name = buffer.readString();
        x = buffer.readFloat();
        y = buffer.readFloat();
        z = buffer.readFloat();
        health = buffer.readInt();
        maxHealth = buffer.readInt();
        mana = buffer.readInt();
        maxMana = buffer.readInt();
        world = buffer.readString();
        isMutualFriend = buffer.readBoolean();
        isMutualPartyMember = buffer.readBoolean();
        isMutualGuildMember = buffer.readBoolean();
    }

    @Override
    public void writeData(HadesBuffer buffer) {
        buffer.writeUUID(user);
        buffer.writeString(name);
        buffer.writeFloat(x);
        buffer.writeFloat(y);
        buffer.writeFloat(z);
        buffer.writeInt(health);
        buffer.writeInt(maxHealth);
        buffer.writeInt(mana);
        buffer.writeInt(maxMana);
        buffer.writeString(world);
        buffer.writeBoolean(isMutualFriend);
        buffer.writeBoolean(isMutualPartyMember);
        buffer.writeBoolean(isMutualGuildMember);
    }

    @Override
    public void process(IHadesClientAdapter handler) {
        handler.handleUpdateMutual(this);
    }

}
