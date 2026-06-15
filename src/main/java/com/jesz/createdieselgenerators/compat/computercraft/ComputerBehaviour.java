package com.jesz.createdieselgenerators.compat.computercraft;

/*
import com.jesz.createdieselgenerators.compat.computercraft.peripherals.ChemicalTurretPeripheral;
import com.jesz.createdieselgenerators.compat.computercraft.peripherals.DieselEnginePeripheral;
import com.jesz.createdieselgenerators.compat.computercraft.peripherals.HugeDieselEnginePeripheral;
import com.jesz.createdieselgenerators.compat.computercraft.peripherals.ModularDieselEnginePeripheral;
*/
import com.jesz.createdieselgenerators.content.diesel_engine.huge.HugeDieselEngineBlockEntity;
import com.jesz.createdieselgenerators.content.diesel_engine.modular.ModularDieselEngineBlockEntity;
import com.jesz.createdieselgenerators.content.diesel_engine.normal.DieselEngineBlockEntity;
import com.jesz.createdieselgenerators.content.turret.ChemicalTurretBlockEntity;
import com.simibubi.create.compat.computercraft.AbstractComputerBehaviour;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;

public class ComputerBehaviour extends AbstractComputerBehaviour {
    public ComputerBehaviour(SmartBlockEntity te) {
        super(te);
    }
    /*
    protected static final Capability<IPeripheral> PERIPHERAL_CAPABILITY =
            CapabilityManager.get(new CapabilityToken<>() {
            });
    LazyOptional<IPeripheral> peripheral;
    NonNullSupplier<IPeripheral> peripheralSupplier;

    public ComputerBehaviour(SmartBlockEntity be) {
        super(be);
        this.peripheralSupplier = getPeripheralFor(be);
    }
    public static NonNullSupplier<IPeripheral> getPeripheralFor(SmartBlockEntity be) {
        if (be instanceof DieselEngineBlockEntity dgbe)
            return () -> new DieselEnginePeripheral(dgbe);
        if (be instanceof ModularDieselEngineBlockEntity ldgbe)
            return () -> new ModularDieselEnginePeripheral(ldgbe);
        if (be instanceof HugeDieselEngineBlockEntity hdebe)
            return () -> new HugeDieselEnginePeripheral(hdebe);
        if (be instanceof ChemicalTurretBlockEntity ctbe)
            return () -> new ChemicalTurretPeripheral(ctbe);
        throw new IllegalArgumentException(
                "No peripheral available for " + ForgeRegistries.BLOCK_ENTITY_TYPES.getKey(be.getType()));
    }

    @Override
    public <T> boolean isPeripheralCap(Capability<T> cap) {
        return cap == PERIPHERAL_CAPABILITY;
    }

    @Override
    public <T> LazyOptional<T> getPeripheralCapability() {
        if (peripheral == null || !peripheral.isPresent())
            peripheral = LazyOptional.of(peripheralSupplier);
        return peripheral.cast();
    }

    @Override
    public void removePeripheral() {
        if (peripheral != null)
            peripheral.invalidate();
    }

     */
}
