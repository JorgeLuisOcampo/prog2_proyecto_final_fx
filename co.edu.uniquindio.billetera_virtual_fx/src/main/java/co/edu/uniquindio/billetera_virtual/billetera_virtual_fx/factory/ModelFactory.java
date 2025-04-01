package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.factory;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.mappers.BilleteraVirtualMappingImpl;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.model.BilleteraVirtual;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service.IBilleteraVirtualMapping;
import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.utils.DataUtil;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private BilleteraVirtual billetera;
    private IBilleteraVirtualMapping mapper;

    private ModelFactory() {
        mapper = new BilleteraVirtualMappingImpl();
        billetera = DataUtil.inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

}
