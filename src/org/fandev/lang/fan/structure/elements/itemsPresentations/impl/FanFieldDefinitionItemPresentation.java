package org.fandev.lang.fan.structure.elements.itemsPresentations.impl;

import org.fandev.lang.fan.psi.api.statements.typeDefs.members.FanField;
import org.fandev.lang.fan.structure.elements.itemsPresentations.FanItemPresentation;
import com.intellij.psi.PsiElement;

/**
 * @author Dror Bereznitsky
 * @date Jan 10, 2009 7:29:09 PM
 */
public class FanFieldDefinitionItemPresentation extends FanItemPresentation
{
	public FanFieldDefinitionItemPresentation(final PsiElement myElement)
	{
		super(myElement);
	}

	public String getPresentableText()
	{
		return ((FanField) myElement).getName();
	}
}