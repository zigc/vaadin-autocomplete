package com.zybnet.autocomplete.client;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.zybnet.autocomplete.shared.AutocompleteFieldSuggestion;

public class OracleSuggestionImpl implements Suggestion {
  
  private final AutocompleteFieldSuggestion wrappedSuggestion;
  
  public OracleSuggestionImpl(AutocompleteFieldSuggestion wrappedSuggestion) {
    this.wrappedSuggestion = wrappedSuggestion;
  }

  @Override
  public String getDisplayString() {
    return wrappedSuggestion.getDisplayString() + (wrappedSuggestion.getDescription() != null ? (wrappedSuggestion.getDescriptionSeparator() + wrappedSuggestion.getDescription()) : "");
  }

  @Override
  public String getReplacementString() {
    return wrappedSuggestion.getDisplayString();
  }
  
  public AutocompleteFieldSuggestion getWrappedSuggestion() {
    return wrappedSuggestion;
  }

}
