package by.dsp.model;

public enum Operation {
	
	TO_11("Скос"),
	TO_12("Четверть"),
	TO_13("Паз"),
	TO_14("Тандембокс"),
	TO_15("Ласточкин хвост"),
	TO_16("Роспуск после оклейки"),
	TO_17("Торцовка"),
	TO_21("Оклейка прямолинейная"),
	TO_22("Оклейка скоса"),
	TO_31("Фрезеровка"),
	TO_32("Присадка"),
	TO_41("Оклейка криволинейная"),
	TO_42("Оклейка острых углов"),
	TO_43("Сростка верхняя деталь"),
	TO_44("Сростка нижняя деталь"),
	TO_45("Сростка верх + ф/панель"),
	TO_46("Сростка ф/панель + низ"),
	TO_51("Сборка фасада");
	
	private String description;
	
	private Operation(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public int getKeyCode(){
		switch(this){
		case TO_11:return 11;
		case TO_12:return 12;
		case TO_13:return 13;
		case TO_14:return 14;
		case TO_15:return 15;
		case TO_16:return 16;
		case TO_17:return 17;
		case TO_21:return 21;
		case TO_22:return 22;
		case TO_31:return 31;
		case TO_32:return 32;
		case TO_41:return 41;
		case TO_42:return 42;
		case TO_43:return 43;
		case TO_44:return 44;
		case TO_45:return 45;
		case TO_46:return 46;
		case TO_51:return 51;
		default: return 0;
		}
	}
	
	public static Operation getOperationFoIndex(int index){
		switch(index){
		case 11:return Operation.TO_11;
		case 12:return Operation.TO_12;
		case 13:return Operation.TO_13;
		case 14:return Operation.TO_14;
		case 15:return Operation.TO_15;
		case 16:return Operation.TO_16;
		case 17:return Operation.TO_17;
		case 21:return Operation.TO_21;
		case 22:return Operation.TO_22;
		case 31:return Operation.TO_31;
		case 32:return Operation.TO_32;
		case 41:return Operation.TO_41;
		case 42:return Operation.TO_42;
		case 43:return Operation.TO_43;
		case 44:return Operation.TO_44;
		case 45:return Operation.TO_45;
		case 46:return Operation.TO_46;
		case 51:return Operation.TO_51;
		default: return null;
		}
	}

}
