
public class ClassRegistry implements gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry {


@Override
public Class<?> getBasicSocialDistanceUtility() {
	return SDUTIL.class;
}

@Override
public Class<?> getSocialDistancDerivingModel() {
	// TODO Auto-generated method stub
	return AppModelDerived.class;
}

@Override
public Class<?> getSocialDistancInferringModel() {
	// TODO Auto-generated method stub
	return AppModelInferred.class;
}

@Override
public Class<?> getSocialDistanceBasicModel() {
	// TODO Auto-generated method stub
	return AppModelBasic.class;
}

@Override
public Class<?> getSocialDistanceClassifierFactory() {
	// TODO Auto-generated method stub
	return ClassifierFactory.class;
}

@Override
public Class<?> getSocialDistanceController() {
	// TODO Auto-generated method stub
	return SDController.class;
}

@Override
public Class<?> getSocialDistanceControllerFactory() {
	// TODO Auto-generated method stub
	return SDControllerFactory.class;
}

@Override
public Class<?> getSocialDistanceInterpolatingModel() {
	// TODO Auto-generated method stub
	return AppModelInterpolation.class;
}

@Override
public Class<?> getSocialDistanceMVCBasicMain() {
	// TODO Auto-generated method stub
	return AppMainBasic.class;
}

@Override
public Class<?> getSocialDistanceMVCDerivingMain() {
	// TODO Auto-generated method stub
	return AppMainDerived.class;
}

@Override
public Class<?> getSocialDistanceMVCInferringMain() {
	// TODO Auto-generated method stub
	return AppMainInferred.class;
}

@Override
public Class<?> getSocialDistanceMVCInterpolatingMain() {
	// TODO Auto-generated method stub
	return AppMainInterpolation.class;
}

@Override
public Class<?> getSocialDistanceModelFactory() {
	// TODO Auto-generated method stub
	return SDModelFactory.class;
}

@Override
public Class<?> getSocialDistanceUilityTesterMain() {
	// TODO Auto-generated method stub
	return SDUTILMain.class;
}

@Override
public Class<?> getSocialDistanceView() {
	// TODO Auto-generated method stub
	return SDAppView.class;
}

@Override
public Class<?> getSocialDistanceViewFactory() {
	// TODO Auto-generated method stub
	return SDViewFactory.class;
}
}

