package com.inno.modelview.dao.impl.DummyData;


import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PopulatorDummyData implements IPopulatorDummnyData {

    @Override
    public Set<CoreEntity> populateEntites() {
        Set<CoreEntity> coreEntities = new HashSet<>();
        coreEntities.add(new CoreEntity("Claim", populateBizView(), populateEntityBuilder(), null, null));
        coreEntities.add(new CoreEntity("Policy", populateBizView(), populateEntityBuilder(), null, null));
        coreEntities.add(new CoreEntity("SC_Job", populateBizView(), populateEntityBuilder(), null, null));
        coreEntities.add(new CoreEntity("GO", populateBizView(), populateEntityBuilder(), null, null));
        coreEntities.add(new CoreEntity("AngularJS", populateBizView(), populateEntityBuilder(), null, null));
        coreEntities.add(new CoreEntity("Stock", populateBizView(), populateEntityBuilder(), null, null));
        coreEntities.add(new CoreEntity("Python", populateBizView(), populateEntityBuilder(), null, null));
        return coreEntities;
    }

    @Override
    public Set<EntityColumn> populateEntityColumns(CoreEntity owner) {
        Set<EntityColumn> entityColumns = new HashSet<>();
        entityColumns.add(new EntityColumn(owner, null, "Claim", "Claim", "VARCHAR"));
        entityColumns.add(new EntityColumn(owner, null, "AAA", "AAA", "VARCHAR"));
        entityColumns.add(new EntityColumn(owner, null, "Policy", "Policy", "Policy"));
        entityColumns.add(new EntityColumn(owner, null, "CCC", "Claim", "VARCHAR"));
        entityColumns.add(new EntityColumn(owner, null, "DDD", "Claim", "VARCHAR"));
        entityColumns.add(new EntityColumn(owner, null, "SC_Job", "SC_Job", "SC_Job"));
        entityColumns.add(new EntityColumn(owner, null, "FFF", "Claim", "VARCHAR"));
        entityColumns.add(new EntityColumn(owner, null, "CreateTime", "Claim", "DATETIME"));
        return entityColumns;
    }

    private String populateEntityBuilder() {
        return "<pre><code class='java'>public class ClassLazyTypeResolver extends LazyTypeResolver {\\r  // Predefined resolvers for frequently used classes\\r  public static final ClassLazyTypeResolver Object = new ClassLazyTypeResolver( Object.class );\\r  public static final ClassLazyTypeResolver String = new ClassLazyTypeResolver( String.class );\\r  ... // many more\\r \\r  private final Class _class;\\r \\r  public ClassLazyTypeResolver( Class type ) {\\r    _class = type;\\r  }\\r  \\r  @Override\\r  protected IType init() {\\r    return TypeSystem.get( _class );\\r  }\\r  public static java.lang.String getCachedFieldName( Class cls ) {\\r    String fieldName = cls.getSimpleName();\\r    try {\\r      for( Field f: ClassLazyTypeResolver.class.getDeclaredFields() ) {\\r        if( f.getName().equals( fieldName ) && ((ClassLazyTypeResolver)f.get( null ))._class == cls ) {\\r          return fieldName;\\r        }\\r      }\\r      return null;\\r    }\\r\\n    catch( IllegalAccessException e ) {\\r      throw new RuntimeException( e );\\r    }\\r  }\\r}</code></pre>";
    }

    private String populateBizView() {
        return "**For Policy perspective**, we offer many more built-in car insurance discounts, such as safe driver, pay-in-full, multi-car, etc.</br>You'll automatically get these during your auto insurance quote no matter if you buy online or on the phone.</br>Just get a free car insurance quote, and we'll find all these savings for you. You won't have to do or say anything else. Easy.</p>";
    }

}
