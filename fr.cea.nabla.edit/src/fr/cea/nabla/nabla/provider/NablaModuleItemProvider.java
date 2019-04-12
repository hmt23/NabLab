/**
 * generated by Xtext 2.15.0
 */
package fr.cea.nabla.nabla.provider;


import fr.cea.nabla.nabla.NablaFactory;
import fr.cea.nabla.nabla.NablaModule;
import fr.cea.nabla.nabla.NablaPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.cea.nabla.nabla.NablaModule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NablaModuleItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NablaModuleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NablaModule_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NablaModule_name_feature", "_UI_NablaModule_type"),
				 NablaPackage.Literals.NABLA_MODULE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(NablaPackage.Literals.NABLA_MODULE__IMPORTS);
			childrenFeatures.add(NablaPackage.Literals.NABLA_MODULE__ITEMS);
			childrenFeatures.add(NablaPackage.Literals.NABLA_MODULE__CONNECTIVITIES);
			childrenFeatures.add(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS);
			childrenFeatures.add(NablaPackage.Literals.NABLA_MODULE__VARIABLES);
			childrenFeatures.add(NablaPackage.Literals.NABLA_MODULE__JOBS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns NablaModule.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/NablaModule"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((NablaModule)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_NablaModule_type") :
			getString("_UI_NablaModule_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(NablaModule.class)) {
			case NablaPackage.NABLA_MODULE__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case NablaPackage.NABLA_MODULE__IMPORTS:
			case NablaPackage.NABLA_MODULE__ITEMS:
			case NablaPackage.NABLA_MODULE__CONNECTIVITIES:
			case NablaPackage.NABLA_MODULE__FUNCTIONS:
			case NablaPackage.NABLA_MODULE__VARIABLES:
			case NablaPackage.NABLA_MODULE__JOBS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__IMPORTS,
				 NablaFactory.eINSTANCE.createImport()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__ITEMS,
				 NablaFactory.eINSTANCE.createItemType()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__CONNECTIVITIES,
				 NablaFactory.eINSTANCE.createConnectivity()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createNablaModule()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createImport()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createItemType()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createJob()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createInstruction()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createSpaceIterator()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createRangeSpaceIterator()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createSingleSpaceIterator()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createConnectivityCall()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createSpaceIteratorRef()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createScalarVarDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createVarGroupDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createVar()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createScalarVar()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createArrayVar()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createConnectivity()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createItemArgType()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createFunctionArg()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createReduction()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createReductionArg()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createReal2Constant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createReal3Constant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createVarRef()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createTimeIterator()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createInstructionBlock()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createAffectation()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createLoop()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createContractedIf()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createEquality()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createComparison()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createPlus()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createMinus()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createMulOrDiv()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createModulo()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createParenthesis()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createUnaryMinus()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createIntConstant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createRealConstant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createBoolConstant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createReal2x2Constant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createReal3x3Constant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createRealXCompactConstant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createMinConstant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createMaxConstant()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createFunctionCall()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createReductionCall()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createInitTimeIterator()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__FUNCTIONS,
				 NablaFactory.eINSTANCE.createNextTimeIterator()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__VARIABLES,
				 NablaFactory.eINSTANCE.createInstruction()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__VARIABLES,
				 NablaFactory.eINSTANCE.createScalarVarDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__VARIABLES,
				 NablaFactory.eINSTANCE.createVarGroupDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__VARIABLES,
				 NablaFactory.eINSTANCE.createInstructionBlock()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__VARIABLES,
				 NablaFactory.eINSTANCE.createAffectation()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__VARIABLES,
				 NablaFactory.eINSTANCE.createLoop()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__VARIABLES,
				 NablaFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.NABLA_MODULE__JOBS,
				 NablaFactory.eINSTANCE.createJob()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == NablaPackage.Literals.NABLA_MODULE__IMPORTS ||
			childFeature == NablaPackage.Literals.NABLA_MODULE__FUNCTIONS ||
			childFeature == NablaPackage.Literals.NABLA_MODULE__ITEMS ||
			childFeature == NablaPackage.Literals.NABLA_MODULE__CONNECTIVITIES ||
			childFeature == NablaPackage.Literals.NABLA_MODULE__JOBS ||
			childFeature == NablaPackage.Literals.NABLA_MODULE__VARIABLES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return NablaEditPlugin.INSTANCE;
	}

}
