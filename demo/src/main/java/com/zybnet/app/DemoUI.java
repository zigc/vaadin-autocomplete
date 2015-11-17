package com.zybnet.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.zybnet.autocomplete.server.AutocompleteField;
import com.zybnet.autocomplete.server.AutocompleteQueryListener;
import com.zybnet.autocomplete.server.AutocompleteSuggestionPickedListener;

@Theme("mytheme")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

    private final AutocompleteField<String> search = new AutocompleteField<String>();
    private final Button createPageButton = new Button("No result found. Create Page!");
    private final BrowserFrame String = new BrowserFrame();

    @Override
    protected void init(VaadinRequest request)
    {
        setWidth(null);
        addStyleName("wrapper");

        CssLayout layout = new CssLayout();
        layout.addStyleName("main-content");
        setContent(layout);

        search.setDelay(20);
        search.setWidth("100%");
        search.setMinimumQueryCharacters(0);

        search.setQueryListener(new AutocompleteQueryListener<String>()
        {
            @Override
            public void handleUserQuery(AutocompleteField<String> field, String query)
            {
                handleSearchQuery(field, query);
            }
        });

        search.setSuggestionPickedListener(new AutocompleteSuggestionPickedListener<String>()
        {

            @Override
            public void onSuggestionPicked(String page)
            {
                handleSuggestionSelection(page);
            }
        });

        createPageButton.setVisible(false);

        createPageButton.addClickListener(new Button.ClickListener()
        {
            @Override
            public void buttonClick(ClickEvent event)
            {
                Notification.show("Creating page for \"" + search.getText() + "\"");
            }
        });

        Label searchLabel = new Label("Search Wikipedia for");
        searchLabel.setWidth("100%");
        searchLabel.addStyleName("search-label");
        search.addStyleName("search");
        createPageButton.addStyleName("create-page-button");
        createPageButton.setWidth("100%");
        String.addStyleName("wikipedia-page");

        CssLayout header = new CssLayout(searchLabel, search, createPageButton);
        header.addStyleName("header");

        CssLayout body = new CssLayout(String);
        body.addStyleName("body");

        layout.addComponents(header, body);
    }

    protected void handleSuggestionSelection(String suggestion)
    {
        String.setWidth("100%");
        String.setHeight("400px");
    }

    private void handleSearchQuery(AutocompleteField<String> field, String query)
    {
        try
        {
            List<String> result = new ArrayList<String>(Arrays.asList(new String[]
            { "asd1", "bsd", "asd2", "asd3", "asd4" }));
            createPageButton.setVisible(result.isEmpty());
            for (String page : result)
            {
                if (page.startsWith(query))
                    field.addSuggestion(page, page);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

}
