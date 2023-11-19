package com.mygdx.collections.BarWithTextCollection;

import com.mygdx.game.BarWithText;

public class BarWithTextCollectionParameters {

		
		private String stringId;
		private BarWithText barWithText ;
		
		
		public BarWithTextCollectionParameters(String stringId , BarWithText barWithText) {
			this.stringId = stringId;
			this.barWithText = barWithText;
		}


		public String getStringId() {
			return stringId;
		}


		public BarWithText getBarWithText() {
			return barWithText;
		}
		
		public static BarWithTextCollectionParameters getParameters(String stringId , BarWithText barWithText) {
			return new BarWithTextCollectionParameters(stringId , barWithText);
		}

}
