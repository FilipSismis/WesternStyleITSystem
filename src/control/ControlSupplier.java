package control;

import java.sql.SQLException;

import db.DBSupplier;
import model.Supplier;

public class ControlSupplier {
	
	private DBSupplier dbSupplier;
	
	public ControlSupplier() {
		dbSupplier = new DBSupplier();
	}
	
	public Supplier findSupplierById(int supplierId)throws SQLException {
		Supplier supplier = dbSupplier.findSupplierById(supplierId);
		return supplier;		
	}
}
