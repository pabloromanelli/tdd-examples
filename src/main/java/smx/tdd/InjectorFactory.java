package smx.tdd;

import com.google.inject.*;

public class InjectorFactory extends AbstractModule{

	public Injector createInjector() {
		return Guice.createInjector(this);
	}

	@Override
	protected void configure() {
		bind(CellCopier.class);
		bind(AreaReferenceCopier.class);
		bind(RegionCopier.class);
	}
	
}
