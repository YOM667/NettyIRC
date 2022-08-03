package me.youm.message;

/**
 * @author : You_M
 * @date : 2022/8/3 11:15 04
 * @projectName : KES-IRC-Server
 * @className : INFORequestPacket
 */
public class INFORequestPacket extends Packet{
    private boolean want;

    public INFORequestPacket() {
    }

    public INFORequestPacket(boolean want) {
        this.want = want;
    }

    public boolean isWant() {
        return want;
    }

    public void setWant(boolean want) {
        this.want = want;
    }

    @Override
    public Byte getCommand() {
        return PacketCommand.INFORequest;
    }
}
