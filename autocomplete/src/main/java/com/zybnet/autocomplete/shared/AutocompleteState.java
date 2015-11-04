package com.zybnet.autocomplete.shared;

import java.util.Collections;
import java.util.List;

import com.vaadin.shared.ui.textfield.AbstractTextFieldState;
import com.vaadin.shared.annotations.DelegateToWidget;

@SuppressWarnings("serial")
public class AutocompleteState extends AbstractTextFieldState {
  public int syncId;
  public List<AutocompleteFieldSuggestion> suggestions = Collections.emptyList();
  public int delayMillis = 300;
  @DelegateToWidget public int minimumQueryCharacters = 3;
  @DelegateToWidget public boolean trimQuery = true;
}
