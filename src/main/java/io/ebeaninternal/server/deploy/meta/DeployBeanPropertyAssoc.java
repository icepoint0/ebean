package io.ebeaninternal.server.deploy.meta;

import io.ebeaninternal.server.deploy.BeanCascadeInfo;
import io.ebeaninternal.server.deploy.BeanTable;

/**
 * Abstract base for properties mapped to an associated bean, list, set or map.
 */
public abstract class DeployBeanPropertyAssoc<T> extends DeployBeanProperty {

	/**
	 * The type of the joined bean.
	 */
	protected Class<T> targetType;

	/**
	 * Persist settings.
	 */
  private final BeanCascadeInfo cascadeInfo = new BeanCascadeInfo();

	/**
	 * The join table information.
	 */
  private BeanTable beanTable;

	/**
	 * Join between the beans.
	 */
  protected final DeployTableJoin tableJoin = new DeployTableJoin();

	/**
	 * Literal added to where clause of lazy loading query.
	 */
  private String extraWhere;

	/**
	 * From the deployment mappedBy attribute.
	 */
  private String mappedBy;

	private String docStoreDoc;

	/**
	 * Construct the property.
	 */
	DeployBeanPropertyAssoc(DeployBeanDescriptor<?> desc, Class<T> targetType) {
		super(desc, targetType, null, null);
		this.targetType = targetType;
	}

  /**
   * Return the target DeployBeanDescriptor for this associated bean property.
   */
	public DeployBeanDescriptor<?> getTargetDeploy() {
		return desc.getDeploy(targetType).getDescriptor();
	}

	/**
	 * Return the type of the target.
	 * <p>
	 * This is the class of the associated bean, or beans contained in a list,
	 * set or map.
	 * </p>
	 */
	public Class<T> getTargetType() {
		return targetType;
	}

	/**
	 * Return a literal expression that is added to the query that lazy loads
	 * the collection.
	 */
	public String getExtraWhere() {
		return extraWhere;
	}

	/**
	 * Set a literal expression to add to the query that lazy loads the
	 * collection.
	 */
	public void setExtraWhere(String extraWhere) {
		this.extraWhere = extraWhere;
	}

	/**
	 * return the join to use for the bean.
	 */
	public DeployTableJoin getTableJoin() {
		return tableJoin;
	}

	/**
	 * Return the BeanTable for this association.
	 * <p>
	 * This has the table name which is used to determine the relationship for
	 * this association.
	 * </p>
	 */
	public BeanTable getBeanTable() {
		return beanTable;
	}

	/**
	 * Set the bean table.
	 */
	public void setBeanTable(BeanTable beanTable) {
		this.beanTable = beanTable;
		getTableJoin().setTable(beanTable.getBaseTable());
	}

	/**
	 * Get the persist info.
	 */
	public BeanCascadeInfo getCascadeInfo() {
		return cascadeInfo;
	}


	/**
	 * Return the mappedBy deployment attribute.
	 * <p>
	 * This is the name of the property in the 'detail' bean that maps back to
	 * this 'master' bean.
	 * </p>
	 */
	public String getMappedBy() {
		return mappedBy;
	}

	/**
	 * Set mappedBy deployment attribute.
	 */
	public void setMappedBy(String mappedBy) {
		if (!"".equals(mappedBy)) {
			this.mappedBy = mappedBy;
		}
	}

	/**
	 * Set DocStoreEmbedded deployment information.
	 */
	public void setDocStoreEmbedded(String embeddedDoc) {
		this.docStoreDoc = embeddedDoc;
	}

  public String getDocStoreDoc() {
    return docStoreDoc;
  }

}
