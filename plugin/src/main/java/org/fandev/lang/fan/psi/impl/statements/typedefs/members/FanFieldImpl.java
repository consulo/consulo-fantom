/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fandev.lang.fan.psi.impl.statements.typedefs.members;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.fandev.icons.Icons;
import org.fandev.lang.fan.FanElementTypes;
import org.fandev.lang.fan.psi.FanType;
import org.fandev.lang.fan.psi.api.statements.typeDefs.members.FanField;
import org.fandev.lang.fan.psi.api.types.FanTypeElement;
import org.fandev.lang.fan.psi.stubs.FanFieldStub;
import com.intellij.lang.ASTNode;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.psi.stubs.IStubElementType;
import consulo.ui.image.Image;

/**
 * @author freds
 * @date Jan 23, 2009
 */
public class FanFieldImpl extends FanSlotElementImpl<FanFieldStub> implements FanField, StubBasedPsiElement<FanFieldStub>
{
	public FanFieldImpl(final FanFieldStub fanFieldStub, @Nonnull final IStubElementType iStubElementType)
	{
		super(fanFieldStub, iStubElementType);
	}

	public FanFieldImpl(ASTNode astNode)
	{
		super(astNode);
	}

	@Override
	public Image getIconInner()
	{
		return Icons.FIELD;
	}

	public String getName()
	{
		return "";
	}

	@Nonnull
	public FanType getType()
	{
		final FanTypeElement classTypeElement = findTypeElement();
		if(classTypeElement != null)
		{
			return classTypeElement.getType();
		}
		return FanType.BOTTOM;
	}

	@Nullable
	@Override
	public FanType getDeclaredType()
	{
		return getType();
	}

	protected FanTypeElement findTypeElement()
	{
		FanTypeElement classTypeElement = (FanTypeElement) findChildByType(FanElementTypes.CLASS_TYPE_ELEMENT);
		if(classTypeElement == null)
		{
			classTypeElement = (FanTypeElement) findChildByType(FanElementTypes.LIST_TYPE);
			if(classTypeElement == null)
			{
				classTypeElement = (FanTypeElement) findChildByType(FanElementTypes.MAP_TYPE);
				if(classTypeElement == null)
				{
					classTypeElement = (FanTypeElement) findChildByType(FanElementTypes.FUNC_TYPE);
				}
			}
		}
		return classTypeElement;
	}
}
