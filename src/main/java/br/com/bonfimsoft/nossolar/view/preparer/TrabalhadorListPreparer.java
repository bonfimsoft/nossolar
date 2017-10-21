package br.com.bonfimsoft.nossolar.view.preparer;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class TrabalhadorListPreparer implements ViewPreparer {

	@Override
	public void execute(Request request, AttributeContext attributeContext) {
		attributeContext
		.putAttribute(
				"javascript-01",
				new Attribute(
						"<script type='text/javascript' src='/nossolar/resources/js/trabalhador.list.js'></script>"));

	}

}