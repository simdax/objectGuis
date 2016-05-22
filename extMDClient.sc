MIDIClientGui : ObjectGui
{
	guiBody{ arg p, b;
		var sj;
		view=StaticText(p, 50@50);
		view.string_("recherche...")
		.onClose_{sj.stop};
		sj=SkipJack({
			if(	MIDIClient.initialized)
			{model.changed(\on)}
			{model.changed(\off)}
		}, 1);
	}
	update{ arg qui, que;
		switch(que,
			\on,  {view.string_("initialisé")},
			\off,  {view.string_("non initialisé")}
		)
	}
}