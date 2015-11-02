package com.zybnet.autocomplete.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AutocompleteFieldSuggestion implements Serializable {
  
  private Integer id;
  private String displayString;
  private String description;
  private String descriptionSeparator;

  public String getDisplayString() {
    return displayString;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setDisplayString(String displayString) {
    this.displayString = displayString;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescriptionSeparator() {
    return descriptionSeparator;
  }

  public void setDescriptionSeparator(String descriptionSeparator) {
    this.descriptionSeparator = descriptionSeparator;
  }
}