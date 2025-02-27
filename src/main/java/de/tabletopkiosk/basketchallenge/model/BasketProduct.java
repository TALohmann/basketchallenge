package de.tabletopkiosk.basketchallenge.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BasketProduct implements IProduct {

	@NotNull
	private String barcode;

	@NotNull
	private String name;

	@Builder.Default
	private int quantity = 1;

	@NotNull
	private double price;

	@Builder.Default
	private double discount = 0.0;

	@Override
	public void addQuantity(int additionalQuantity) {
		this.quantity += additionalQuantity;
	}

	@Override
	public void removeQuantity(int quantityToRemove) {
		if (this.quantity >= quantityToRemove) {
			quantity -= quantityToRemove;
		}
	}

	public boolean isEmpty() {
		if (quantity == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
