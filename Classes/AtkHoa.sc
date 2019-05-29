AtkHoa {
    classvar <speedOfSound, <refRadius;
	classvar <nearZero;
	classvar <defaultOrder;
	classvar <formatDict;

	*initClass {
		speedOfSound = 343.0;  // (m/s)
		refRadius = 1.5;  // reference encoding / decoding radius, i.e., basic radius
		nearZero = -180.dbamp;  // zero optimisation threshold

		defaultOrder = 3;

		formatDict =  Dictionary.with(*[
			\atk->[ \acn, \n3d ],          // atk, mpegH
			\ambix->[ \acn, \sn3d ],   // ambix
			\fuma->[ \fuma, \fuma ]  // fuma
		]);
	}

	*format {
		^formatDict[\atk]
	}

	*ordering {
		^formatDict[\atk][0]
	}

	*normalisation {
		^formatDict[\atk][1]
	}

	*setSpeedOfSound { |mps|
		var mpsAsFloat;
		mpsAsFloat = mps.asFloat;
		/*
		TODO: run initializations necessary when changing speedOfSound
		after resources have already been allocated at a different speedOfSound
		*/
		speedOfSound = mpsAsFloat;
		^mpsAsFloat
	}

	*setRefRadius { |radius|
		var radiusAsFloat = radius.asFloat;
		/*
		TODO: run initializations necessary when changing refRadius
		after resources have already been allocated at a different refRadius
		*/
		refRadius = radiusAsFloat;
		^radiusAsFloat
	}

	*setNearZero { |zero|
		var zeroAbs = zero.abs;
		nearZero = zeroAbs;
		^zeroAbs
	}

	*setDefaultOrder { |order|
		var orderAsInteger = order.asInteger;
		/*
		TODO: run initializations necessary when changing order
		after resources have already been allocated at a different order
		*/
		defaultOrder = orderAsInteger;
		^orderAsInteger
	}
}
