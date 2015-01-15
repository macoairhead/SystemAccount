/**
 * usersviewmodel.js
 */

// Gistのデータ用ViewModel
var UsersViewModel = (function () {
  // クラス定義、コンストラクタ
  function UsersViewModel() {
    var self = this;
    self.users = ko.observableArray([]);
}

	// データコレクション
  UsersViewModel.prototype.search = function(id) {
		var usersapiurl = "http://maco-pc:8080/SystemAccount/SystemAccount/User/Inhouseuser?UserID="
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
				this.users(marray);
			}
		});
	};
	UsersViewModel.prototype.listsearch = function() {
		var usersapiurl = "http://maco-pc:8080/SystemAccount/SystemAccount/User/Inhouseusers";
		$.ajax({
			async : false,
			url : usersapiurl,
			context: this,
			type : "GET",
			dataType : "json",
			error : console.log("だめです"),
			success : function(response) {
				var marray = [];
				for (var i = 0; i < response.length; i++) {
					marray.push(new UserModel(response[i]));
				}
				this.users(marray);
			}
		});
	};
	UsersViewModel.prototype.unitsearch = function() {
		var usersapiurl = "http://maco-pc:8080/SystemAccount/SystemAccount/Unit/Units";
		$.ajax({
			async : false,
			url : usersapiurl,
			context: this,
			type : "GET",
			dataType : "json",
			error : console.log("だめです"),
			success : function(response) {
				var marray = [];
				for (var i = 0; i < response.length; i++) {
					var a = [];
					for (var t = 0; t < response[i].inhouseusers.length; t++) {
						var u = new UserModel(response[i].inhouseusers[t]);
						u.setunit(response[i].UnitName);
						marray.push(u);
					}
				}
				this.users(marray);
			}
		});
	};
  return UsersViewModel;
})();