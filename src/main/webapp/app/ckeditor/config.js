/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see LICENSE.md or
 *          http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	 // 界面语言，默认为 'en'
	config.language = 'zh-cn';
	// 界面颜色
	config.uiColor = '#27c0d8';
	// 编辑器样式，有三种：'kama'（默认）、'office2003'、'v2'
	//config.skin = 'office2003';
	  /// /主题
	config.theme = 'default';
	  /// /撤销的记录步数 plugins/undo/plugin.js
	config.undoStackSize =20;
	//图片上传路径
	config.filebrowserUploadUrl="/xyan/admin/images/upload";
	/*var pathName = window.document.location.pathname;
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    config.filebrowserImageUploadUrl = projectName+'admin/image/upload'; //固定路径
*/} ;
