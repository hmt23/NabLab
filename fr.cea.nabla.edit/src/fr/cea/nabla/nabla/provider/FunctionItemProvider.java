/**
 * generated by Xtext 2.15.0
 */
package fr.cea.nabla.nabla.provider;


import fr.cea.nabla.nabla.Function;
import fr.cea.nabla.nabla.NablaFactory;
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
 * This is the item provider adapter for a {@link fr.cea.nabla.nabla.Function} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionItemProvider 
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
	public FunctionItemProvider(AdapterFactory adapterFactory) {
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
			addExternalPropertyDescriptor(object);
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
				 getString("_UI_Function_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Function_name_feature", "_UI_Function_type"),
				 NablaPackage.Literals.FUNCTION__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the External feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExternalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Function_external_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Function_external_feature", "_UI_Function_type"),
				 NablaPackage.Literals.FUNCTION__EXTERNAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(NablaPackage.Literals.FUNCTION__DIM_VARS);
			childrenFeatures.add(NablaPackage.Literals.FUNCTION__IN_TYPES);
			childrenFeatures.add(NablaPackage.Literals.FUNCTION__RETURN_TYPE);
			childrenFeatures.add(NablaPackage.Literals.FUNCTION__IN_ARGS);
			childrenFeatures.add(NablaPackage.Literals.FUNCTION__BODY);
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
	 * This returns Function.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Function"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Function)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Function_type") :
			getString("_UI_Function_type") + " " + label;
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

		switch (notification.getFeatureID(Function.class)) {
			case NablaPackage.FUNCTION__NAME:
			case NablaPackage.FUNCTION__EXTERNAL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case NablaPackage.FUNCTION__DIM_VARS:
			case NablaPackage.FUNCTION__IN_TYPES:
			case NablaPackage.FUNCTION__RETURN_TYPE:
			case NablaPackage.FUNCTION__IN_ARGS:
			case NablaPackage.FUNCTION__BODY:
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
				(NablaPackage.Literals.FUNCTION__DIM_VARS,
				 NablaFactory.eINSTANCE.createDimensionVar()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__IN_TYPES,
				 NablaFactory.eINSTANCE.createArgOrVarType()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__RETURN_TYPE,
				 NablaFactory.eINSTANCE.createArgOrVarType()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__IN_ARGS,
				 NablaFactory.eINSTANCE.createArg()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__BODY,
				 NablaFactory.eINSTANCE.createInstruction()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__BODY,
				 NablaFactory.eINSTANCE.createSimpleVarDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__BODY,
				 NablaFactory.eINSTANCE.createVarGroupDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__BODY,
				 NablaFactory.eINSTANCE.createInstructionBlock()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__BODY,
				 NablaFactory.eINSTANCE.createLoop()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__BODY,
				 NablaFactory.eINSTANCE.createAffectation()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__BODY,
				 NablaFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(NablaPackage.Literals.FUNCTION__BODY,
				 NablaFactory.eINSTANCE.createReturn()));
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
			childFeature == NablaPackage.Literals.FUNCTION__IN_TYPES ||
			childFeature == NablaPackage.Literals.FUNCTION__RETURN_TYPE;

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
