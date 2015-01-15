/**
 * unitsviewmodel.js
 */

// データ用ViewModel
var UnitsViewModel = (function () {
  // クラス定義、コンストラクタ
  function UnitsViewModel() {
    var self = this;
    self.units = ko.observableArray([]);
}

	// データコレクション
  UnitsViewModel.prototype.search = function(id) {
		var usersapiurl = "http://maco-pc:8080/SystemAccount/SystemAccount/Unit/Unit?UnitID="
				+ id;
		$.ajax({
			async : false,
			url : usersapiurl,
			context: this,
			type : "GET",
			dataType : "json",
			error : console.log("だめです"),
			success : function(response) {
				var marray = [];
				marray.push(new UserModel(response));
				this.units(marray);
			}
		});
	};
	UnitsViewModel.prototype.listsearch = function() {
		var unitsapiurl = "http://maco-pc:8080/SystemAccount/SystemAccount/Unit/Units";
		$.ajax({
			async : false,
			url : unitsapiurl,
			context: this,
			type : "GET",
			dataType : "json",
			error : console.log("だめです"),
			success : function(response) {
				var marray = [];
				for (var i = 0; i < response.length; i++) {
					marray.push(new UnitModel(response[i]));
				}
				this.units(marray);
			}
		});
	};

  return UnitsViewModel;
})();